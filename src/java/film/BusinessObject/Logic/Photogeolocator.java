/**
 * @author Franky Laseure
 */
package film.BusinessObject.Logic;

import data.gis.shape.piPolyline;
import data.google.geocode.Googleaddresscomponent;
import data.google.geocode.Googleaddresssubcomponent;
import data.google.geocode.Googlegeocode;
import data.google.geocode.Googlegeocodestatus;
import data.osm.geocode.OSMgeocode;
import db.SQLTqueue;
import db.SQLreader;
import film.entity.pk.Arealevel1PK;
import film.entity.pk.Arealevel2PK;
import film.entity.pk.Arealevel3PK;
import film.entity.pk.RoutePK;
import film.interfaces.logicentity.IPhoto;
import film.logicentity.Arealevel1;
import film.logicentity.Arealevel2;
import film.logicentity.Arealevel3;
import film.logicentity.Country;
import film.logicentity.Locality;
import film.logicentity.Postalcode;
import film.logicentity.Route;
import film.logicentity.Sublocality;
import general.exception.DBException;
import general.exception.DataException;

public class Photogeolocator {

    private SQLreader sqlreader = new SQLreader();
    BLcountry blcountry = new BLcountry(sqlreader);
    BLarealevel1 blarealevel1 = new BLarealevel1(sqlreader);
    BLarealevel2 blarealevel2 = new BLarealevel2(sqlreader);
    BLarealevel3 blarealevel3 = new BLarealevel3(sqlreader);
    BLpostalcode blpostalcode = new BLpostalcode(sqlreader);
    BLlocality bllocality = new BLlocality(sqlreader);
    BLsublocality blsublocality = new BLsublocality(sqlreader);
    BLroute blroute = new BLroute(sqlreader);
    
    public void google_processreversegeocode(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
        StringBuilder datalog = new StringBuilder("Reverse geocode for ").append(photo.getPrimaryKey().getFilm()).append("-").append(photo.getPrimaryKey().getId());
        try {
            blcountry.setAuthenticated(true);
            blarealevel1.setAuthenticated(true);
            blarealevel2.setAuthenticated(true);
            blarealevel3.setAuthenticated(true);
            blpostalcode.setAuthenticated(true);
            bllocality.setAuthenticated(true);
            blsublocality.setAuthenticated(true);
            blroute.setAuthenticated(true);
            Googlegeocode geocode = new Googlegeocode(photo.getReversegeocode());
            if(geocode.getStatus().equals(Googlegeocodestatus.STATUS_OK)) {
                google_processreversegeocode_statusok(geocode, datalog, transactionqueue, photo);
            } else {
                photo.setReversegeocode(null);
                datalog.append("\r\n").append(geocode.getStatus());
                throw new DataException(geocode.getStatus());
            }
        }
        catch(NullPointerException e) {
            datalog.append("\r\n").append(photo.getReversegeocode());
            throw new DataException(datalog.toString());
        }
    }

    private void google_processreversegeocode_statusok(Googlegeocode geocode, StringBuilder datalog, SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
        Googleaddresscomponent compcountry = geocode.getCountry();
        Googleaddresscomponent compal1 = geocode.getArealevel1();
        Googleaddresscomponent compal2 = geocode.getArealevel2();
        Googleaddresscomponent compal3 = geocode.getArealevel3();
        Googleaddresscomponent comppostalcode = geocode.getPostalcode();
        //in case there is a prefix, it contains the bounds for the Postalcode
        Googleaddresscomponent comppostalcodeprefix = geocode.getPostalcodePrefix();
        Googleaddresscomponent complocality = geocode.getLocality();
        Googleaddresscomponent compsublocality = geocode.getSublocality();
        Googleaddresscomponent comproute = geocode.getRoute();
        Googleaddresscomponent compstreetaddress = geocode.getStreetaddress();
        
        piPolyline bounds;
        piPolyline viewport;
        Country country = null;
        datalog.append("\r\n").append("compcountry Null ").append((compcountry==null));
        if(compcountry!=null) {
            datalog.append("\r\n").append("Country Shortname ");
            datalog.append("\r\n").append(compcountry.getCountry().getShortname());
            country = new Country(compcountry.getCountry().getShortname());
            datalog.append("\r\n").append("Country Longname ");
            datalog.append("\r\n").append(compcountry.getCountry().getLongname());
            country.setName(compcountry.getCountry().getLongname());
            country.setLocation(compcountry.getLocation().extractpiPoint());
            bounds = new piPolyline(country.getLocation().getSrid());
            bounds.addPoint(compcountry.getBounds().extractpiPointNE());
            bounds.addPoint(compcountry.getBounds().extractpiPointSW());
            country.setBounds(bounds);
            viewport = new piPolyline(country.getLocation().getSrid());
            viewport.addPoint(compcountry.getViewport().extractpiPointNE());
            viewport.addPoint(compcountry.getViewport().extractpiPointSW());
            country.setViewport(viewport);
            country.setApproximate(compcountry.getIsApproximate());
            country.setHasarealevel1(compal1!=null);
            country.setHasarealevel2(compal2!=null);
            country.setHasarealevel3(compal3!=null);
        } else {
            Googleaddresssubcomponent subcountrycomp = geocode.findCountry();
            datalog.append("\r\n").append("Country Shortname ");
            datalog.append("\r\n").append(subcountrycomp.getShortname());
            country = new Country(subcountrycomp.getShortname());
            datalog.append("\r\n").append("Country Longname ");
            datalog.append("\r\n").append(subcountrycomp.getLongname());
            country.setName(subcountrycomp.getLongname());
            country.setApproximate(true);
            country.setHasarealevel1(compal1!=null);
            country.setHasarealevel2(compal2!=null);
            country.setHasarealevel3(compal3!=null);
        }
        if(country!=null) {
            blcountry.insertupdateCountry(transactionqueue, country);
        }
        
        Arealevel1 al1 = null;
        if(compal1==null) {
            al1 = new Arealevel1(new Arealevel1PK(
                    country.getPrimaryKey().getCode(),
                    country.getPrimaryKey().getCode()));
            if(compstreetaddress!=null && compstreetaddress.getArealevel1()!=null) {
                al1.getPrimaryKey().setAl1code(compstreetaddress.getArealevel1().getShortname());
                al1.setName(compstreetaddress.getArealevel1().getLongname());
            } else if(comproute!=null && comproute.getArealevel1()!=null) {
                al1.getPrimaryKey().setAl1code(comproute.getArealevel1().getShortname());
                al1.setName(comproute.getArealevel1().getLongname());
            }
        } else {
            al1 = new Arealevel1(new Arealevel1PK(
                    country.getPrimaryKey().getCode(),
                    compal1.getArealevel1().getShortname()));
            al1.setName(compal1.getArealevel1().getLongname());
            al1.setLocation(compal1.getLocation().extractpiPoint());
            bounds = new piPolyline(al1.getLocation().getSrid());
            bounds.addPoint(compal1.getBounds().extractpiPointNE());
            bounds.addPoint(compal1.getBounds().extractpiPointSW());
            al1.setBounds(bounds);
            viewport = new piPolyline(al1.getLocation().getSrid());
            viewport.addPoint(compal1.getViewport().extractpiPointNE());
            viewport.addPoint(compal1.getViewport().extractpiPointSW());
            al1.setViewport(viewport);
            al1.setApproximate(compal1.getIsApproximate());
        }
        blarealevel1.insertupdateArealevel1(transactionqueue, al1);
        
        Arealevel2 al2 = null;
        if(compal2==null) {
            al2 = new Arealevel2(new Arealevel2PK(
                    al1.getPrimaryKey().getCountrycode(),
                    al1.getPrimaryKey().getAl1code(),
                    al1.getPrimaryKey().getAl1code()));
            if(compstreetaddress!=null && compstreetaddress.getArealevel2()!=null) {
                al2.getPrimaryKey().setAl2code(compstreetaddress.getArealevel2().getShortname());
                al2.setName(compstreetaddress.getArealevel2().getLongname());
            } else if(comproute!=null && comproute.getArealevel2()!=null) {
                al2.getPrimaryKey().setAl2code(comproute.getArealevel2().getShortname());
                al2.setName(comproute.getArealevel2().getLongname());
            }
        } else {
            al2 = new Arealevel2(new Arealevel2PK(
                    al1.getPrimaryKey().getCountrycode(),
                    al1.getPrimaryKey().getAl1code(),
                    compal2.getArealevel2().getShortname()));
            al2.setName(compal2.getArealevel2().getLongname());
            al2.setLocation(compal2.getLocation().extractpiPoint());
            bounds = new piPolyline(al2.getLocation().getSrid());
            bounds.addPoint(compal2.getBounds().extractpiPointNE());
            bounds.addPoint(compal2.getBounds().extractpiPointSW());
            al2.setBounds(bounds);
            viewport = new piPolyline(al2.getLocation().getSrid());
            viewport.addPoint(compal2.getViewport().extractpiPointNE());
            viewport.addPoint(compal2.getViewport().extractpiPointSW());
            al2.setViewport(viewport);
            al2.setApproximate(compal2.getIsApproximate());
        }
        blarealevel2.insertupdateArealevel2(transactionqueue, al2);
        //log.finer("Area Level 2 check: " + al2.getPrimaryKey().getKeystring());
        
        Arealevel3 al3 = null;
        if(compal3==null) {
            al3 = new Arealevel3(new Arealevel3PK(
                    al2.getPrimaryKey().getCountrycode(),
                    al2.getPrimaryKey().getAl1code(),
                    al2.getPrimaryKey().getAl2code(),
                    al2.getPrimaryKey().getAl2code()));
            if(compstreetaddress!=null && compstreetaddress.getArealevel3()!=null) {
                al3.getPrimaryKey().setAl3code(compstreetaddress.getArealevel3().getShortname());
                al3.setName(compstreetaddress.getArealevel3().getLongname());
            } else if(comproute!=null && comproute.getArealevel3()!=null) {
                al3.getPrimaryKey().setAl3code(comproute.getArealevel3().getShortname());
                al3.setName(comproute.getArealevel3().getLongname());
            }
        } else {
            al3 = new Arealevel3(new Arealevel3PK(
                    al2.getPrimaryKey().getCountrycode(),
                    al2.getPrimaryKey().getAl1code(),
                    al2.getPrimaryKey().getAl2code(),
                    compal3.getArealevel3().getShortname()));
            al3.setName(compal3.getArealevel3().getLongname());
            al3.setLocation(compal3.getLocation().extractpiPoint());
            bounds = new piPolyline(al3.getLocation().getSrid());
            bounds.addPoint(compal3.getBounds().extractpiPointNE());
            bounds.addPoint(compal3.getBounds().extractpiPointSW());
            al3.setBounds(bounds);
            viewport = new piPolyline(al3.getLocation().getSrid());
            viewport.addPoint(compal3.getViewport().extractpiPointNE());
            viewport.addPoint(compal3.getViewport().extractpiPointSW());
            al3.setViewport(viewport);
            al3.setApproximate(compal3.getIsApproximate());
        }
        blarealevel3.insertupdateArealevel3(transactionqueue, al3);
        //log.finer("Area Level 3 check: " + al3.getPrimaryKey().getKeystring());
        
        Postalcode postalcode = null;
        if(comppostalcode==null) {
            String postalcodestring = "000000";
            if(compstreetaddress!=null && compstreetaddress.getPostalcode()!=null) {
                postalcodestring = compstreetaddress.getPostalcode().getShortname();
            } else if(comproute!=null && comproute.getPostalcode()!=null) {
                postalcodestring = comproute.getPostalcode().getShortname();
            }
            postalcode = new Postalcode(
                    country.getPrimaryKey().getCode(),
                    postalcodestring);
            postalcode.setArealevel3PK(al3.getPrimaryKey());
        } else {
            postalcode = new Postalcode(
                    country.getPrimaryKey().getCode(),
                    comppostalcode.getPostalcode().getShortname());
            postalcode.setArealevel3PK(al3.getPrimaryKey());
            postalcode.setLocation(comppostalcode.getLocation().extractpiPoint());
            bounds = new piPolyline(postalcode.getLocation().getSrid());
            if(comppostalcode.getBounds()!=null) {
                bounds.addPoint(comppostalcode.getBounds().extractpiPointNE());
                bounds.addPoint(comppostalcode.getBounds().extractpiPointSW());
            } else if(comppostalcodeprefix!=null && comppostalcodeprefix.getBounds()!=null) {
                bounds.addPoint(comppostalcodeprefix.getBounds().extractpiPointNE());
                bounds.addPoint(comppostalcodeprefix.getBounds().extractpiPointSW());
            } else {
                bounds.addPoint(comppostalcode.getViewport().extractpiPointNE());
                bounds.addPoint(comppostalcode.getViewport().extractpiPointSW());
            }
            postalcode.setBounds(bounds);
            viewport = new piPolyline(postalcode.getLocation().getSrid());
            viewport.addPoint(comppostalcode.getViewport().extractpiPointNE());
            viewport.addPoint(comppostalcode.getViewport().extractpiPointSW());
            postalcode.setViewport(viewport);
            postalcode.setApproximate(comppostalcode.getIsApproximate());
        }
        blpostalcode.insertcheckPostalcode(transactionqueue, postalcode);
        //log.finer("Postal Code check: " + postalcode.getPrimaryKey().getKeystring());
        
        Locality locality = null;
        if(complocality==null) {
            String localityname = al3.getPrimaryKey().getAl3code();
            if(compstreetaddress!=null && compstreetaddress.getLocality()!=null) {
                localityname = compstreetaddress.getLocality().getLongname();
            } else if(comproute!=null && comproute.getLocality()!=null) {
                localityname = comproute.getLocality().getLongname();
            }
            locality = new Locality(
                    postalcode.getPrimaryKey().getCountrycode(),
                    postalcode.getPrimaryKey().getPostalcode(),
                    localityname);
        } else {
            locality = new Locality(
                    postalcode.getPrimaryKey().getCountrycode(),
                    postalcode.getPrimaryKey().getPostalcode(),
                    complocality.getLocality().getLongname());
            locality.setLocation(complocality.getLocation().extractpiPoint());
            bounds = new piPolyline(locality.getLocation().getSrid());
            bounds.addPoint(complocality.getBounds().extractpiPointNE());
            bounds.addPoint(complocality.getBounds().extractpiPointSW());
            locality.setBounds(bounds);
            viewport = new piPolyline(locality.getLocation().getSrid());
            viewport.addPoint(complocality.getViewport().extractpiPointNE());
            viewport.addPoint(complocality.getViewport().extractpiPointSW());
            locality.setViewport(viewport);
            locality.setApproximate(complocality.getIsApproximate());
            locality.setHassublocality(compsublocality!=null);
        }
        bllocality.insertcheckLocality(transactionqueue, locality);
        //log.finer("Locality check: " + locality.getPrimaryKey().getKeystring());
        
        Sublocality sublocality = null;
        if(compsublocality==null) {
            String sublocalityname = locality.getPrimaryKey().getLocality();
            if(compstreetaddress!=null && compstreetaddress.getSublocality()!=null) {
                sublocalityname = compstreetaddress.getSublocality().getLongname();
            } else if(comproute!=null && comproute.getSublocality()!=null) {
                sublocalityname = comproute.getSublocality().getLongname();
            }
            sublocality = new Sublocality(
                    locality.getPrimaryKey().getCountrycode(),
                    locality.getPrimaryKey().getPostalcode(),
                    locality.getPrimaryKey().getLocality(),
                    sublocalityname);
        } else {
            sublocality = new Sublocality(
                    locality.getPrimaryKey().getCountrycode(),
                    locality.getPrimaryKey().getPostalcode(),
                    locality.getPrimaryKey().getLocality(),
                    compsublocality.getSublocality().getLongname());
            sublocality.setLocation(compsublocality.getLocation().extractpiPoint());
            bounds = new piPolyline(sublocality.getLocation().getSrid());
            bounds.addPoint(compsublocality.getBounds().extractpiPointNE());
            bounds.addPoint(compsublocality.getBounds().extractpiPointSW());
            sublocality.setBounds(bounds);
            viewport = new piPolyline(sublocality.getLocation().getSrid());
            viewport.addPoint(compsublocality.getViewport().extractpiPointNE());
            viewport.addPoint(compsublocality.getViewport().extractpiPointSW());
            sublocality.setViewport(viewport);
            sublocality.setApproximate(compsublocality.getIsApproximate());
        }
        blsublocality.insertcheckSublocality(transactionqueue, sublocality);
        //log.finer("Sublocality check: " + sublocality.getPrimaryKey().getKeystring());
        
        Route route = new Route(new RoutePK());
        route.getPrimaryKey().setSublocalityPK(sublocality.getPrimaryKey());
        if(compstreetaddress!=null) {
            route.getPrimaryKey().setRoutecode(compstreetaddress.getRoute().getShortname());
            route.setName(compstreetaddress.getRoute().getLongname());
            //            photo.setFormattedaddress(compstreetaddress.getFormatted());
        } else if(comproute!=null) {
            route.getPrimaryKey().setRoutecode(comproute.getRoute().getShortname());
            route.setName(comproute.getRoute().getLongname());
            route.setLocation(comproute.getLocation().extractpiPoint());
            bounds = new piPolyline(route.getLocation().getSrid());
            bounds.addPoint(comproute.getBounds().extractpiPointNE());
            bounds.addPoint(comproute.getBounds().extractpiPointSW());
            route.setBounds(bounds);
            viewport = new piPolyline(route.getLocation().getSrid());
            viewport.addPoint(comproute.getViewport().extractpiPointNE());
            viewport.addPoint(comproute.getViewport().extractpiPointSW());
            route.setViewport(viewport);
            route.setApproximate(comproute.getIsApproximate());
            //            photo.setFormattedaddress(comproute.getFormatted());
        } else {
            route.getPrimaryKey().setRoutecode(sublocality.getPrimaryKey().getSublocality());
        }
        blroute.insertcheckRoute(transactionqueue, route);
        //log.finer("Route check: " + route.getPrimaryKey().getKeystring());
        
        photo.setRoutePK(route.getPrimaryKey());
        if(compstreetaddress!=null) {
            photo.setStreetnumber(compstreetaddress.getStreetnumber().getShortname());
        }
    }
    
    public void processreversegeocode(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
        StringBuilder datalog = new StringBuilder("Reverse geocode for ").append(photo.getPrimaryKey().getFilm()).append("-").append(photo.getPrimaryKey().getId());
        try {
            blcountry.setAuthenticated(true);
            blarealevel1.setAuthenticated(true);
            blarealevel2.setAuthenticated(true);
            blarealevel3.setAuthenticated(true);
            blpostalcode.setAuthenticated(true);
            bllocality.setAuthenticated(true);
            blsublocality.setAuthenticated(true);
            blroute.setAuthenticated(true);
            OSMgeocode geocode = new OSMgeocode(photo.getReversegeocode());

            piPolyline bounds;
            piPolyline viewport;
            datalog.append("\r\n").append("country ").append(geocode.getCountrycode()).append(" ").append(geocode.getCountry());
            Country country = new Country(geocode.getCountrycode());
            country.setName(geocode.getCountry());
            country.setLocation(geocode.getLocation().extractpiPoint());
            blcountry.insertupdateCountry(transactionqueue, country);

            //Arealevel1 -> state
            datalog.append("\r\n").append("Arealevel1 state ").append(geocode.getState());
            Arealevel1 al1 = null;
            al1 = new Arealevel1(new Arealevel1PK(
                    country.getPrimaryKey().getCode(), 
                    geocode.getState()));
            al1.setName(geocode.getState());
            al1.setLocation(geocode.getLocation().extractpiPoint());

            blarealevel1.insertupdateArealevel1(transactionqueue, al1);

            //Arealevel2 -> county
            datalog.append("\r\n").append("Arealevel2 county ").append(geocode.getCounty());
            String countyname = geocode.getCounty();
            if(countyname==null) {
                countyname = al1.getPrimaryKey().getAl1code();
            }
            Arealevel2 al2 = null;
            al2 = new Arealevel2(new Arealevel2PK(
                    al1.getPrimaryKey().getCountrycode(), 
                    al1.getPrimaryKey().getAl1code(), 
                    countyname));
            al2.setName(countyname);
            al2.setLocation(geocode.getLocation().extractpiPoint());

            blarealevel2.insertupdateArealevel2(transactionqueue, al2);

            //Arealevel3 -> city
            String city = geocode.getCity();
            if(city==null) {
                city = al2.getPrimaryKey().getAl2code();
            }
            datalog.append("\r\n").append("Arealevel3 city ").append(city);
            Arealevel3 al3 = null;
            al3 = new Arealevel3(new Arealevel3PK(
                    al2.getPrimaryKey().getCountrycode(), 
                    al2.getPrimaryKey().getAl1code(), 
                    al2.getPrimaryKey().getAl2code(),
                    city));
            al3.setName(city);
            al3.setLocation(geocode.getLocation().extractpiPoint());
            blarealevel3.insertupdateArealevel3(transactionqueue, al3);

            datalog.append("\r\n").append("Postalcode ").append(geocode.getPostcode());
            Postalcode postalcode = null;
            postalcode = new Postalcode(
                    country.getPrimaryKey().getCode(), 
                    geocode.getPostcode());
            postalcode.setArealevel3PK(al3.getPrimaryKey());
            postalcode.setLocation(geocode.getLocation().extractpiPoint());
            bounds = new piPolyline(postalcode.getLocation().getSrid());
            blpostalcode.insertcheckPostalcode(transactionqueue, postalcode);

            datalog.append("\r\n").append("Locality town ").append(geocode.getTown());
            datalog.append("\r\n").append("Locality village ").append(geocode.getSuburb());
            datalog.append("\r\n").append("Locality suburb ").append(geocode.getSuburb());
            datalog.append("\r\n").append("Locality citydistrict ").append(geocode.getCitydistrict());
            datalog.append("\r\n").append("Locality statedisctrict ").append(geocode.getStatedistrict());
            String localityname = geocode.getTown();
            if(localityname==null) {
                localityname = geocode.getVillage();
            }
            if(localityname==null) {
                localityname = geocode.getSuburb();
            }
            if(localityname==null) {
                localityname = geocode.getCitydistrict();
            }
            if(localityname==null) {
                localityname = geocode.getStatedistrict();
            }
            Locality locality = null;
            locality = new Locality(
                    postalcode.getPrimaryKey().getCountrycode(),
                    postalcode.getPrimaryKey().getPostalcode(),
                    localityname);
            locality.setLocation(geocode.getLocation().extractpiPoint());
            bounds = new piPolyline(locality.getLocation().getSrid());
            bllocality.insertcheckLocality(transactionqueue, locality);

            datalog.append("\r\n").append("Sublocality neighbourhood ").append(geocode.getNeighbourhood());
            Sublocality sublocality = null;
            String sublocalityname = geocode.getNeighbourhood();
            if(sublocalityname==null) sublocalityname = localityname;
            sublocality = new Sublocality(
                    locality.getPrimaryKey().getCountrycode(),
                    locality.getPrimaryKey().getPostalcode(),
                    locality.getPrimaryKey().getLocality(),
                    sublocalityname);
            sublocality.setLocation(geocode.getLocation().extractpiPoint());
            blsublocality.insertcheckSublocality(transactionqueue, sublocality);

            datalog.append("\r\n").append("Route road ").append(geocode.getRoad());
            datalog.append("\r\n").append("Route footway ").append(geocode.getFootway());
            String routename = geocode.getRoad();
            if(geocode.getRoad()==null) {
                routename = geocode.getFootway();
            }
            if(routename==null) {
                routename = sublocality.getPrimaryKey().getSublocality();
            }
            Route route = new Route(new RoutePK());
            route.getPrimaryKey().setSublocalityPK(sublocality.getPrimaryKey());
            route.getPrimaryKey().setRoutecode(routename);
            route.setName(routename);
            route.setLocation(geocode.getLocation().extractpiPoint());
            blroute.insertcheckRoute(transactionqueue, route);

            photo.setRoutePK(route.getPrimaryKey());
            if(geocode.getHousenumber()!=null) {
                datalog.append("\r\n").append("Streetnumber housenumber ").append(geocode.getHousenumber());
                photo.setStreetnumber(geocode.getHousenumber());
            }
        }
        catch(NullPointerException e) {
            datalog.append("\r\n").append(photo.getReversegeocode());
            datalog.append("\r\n").append(e.getMessage());
            throw new DataException(datalog.toString());
        }
    }
    
}
