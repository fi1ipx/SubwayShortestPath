///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.fi1.SubwayShortestPath.rs;
//
//import com.fi1.SubwayShortestPath.database.StationDB;
//import com.fi1.SubwayShortestPath.impls.ObjectsListsImpl;
//import java.util.List;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import com.fi1.SubwayShortestPath.objects.Station;
//
///**
// * REST Web Service
// *
// * @author Fil
// */
//@Path("/subwaypath")
//public class SubwayPath {
//
////    @Context
////    private UriInfo context;
//
//    /**
//     * Creates a new instance of SubwayPath
//     */
//    public SubwayPath() {
//    }
//
//    /**
//     * Retrieves representation of an instance of rs.SubwayPath
//     * @return an instance of java.lang.String
//     */
//    private ObjectsListsImpl searchImpl = new ObjectsListsImpl();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/allstations")
//    public ResponseList getAllStations() {
//        List<Station> cityList = searchImpl.getStations();
//        ResponseList responseList = new ResponseList();
//        responseList.setList(cityList);
//        return responseList;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/getPath")
//    public ResponseList getPath(@QueryParam("src") int src, @QueryParam("dst") int dst) {
//        List<Station> cityList = searchImpl.getPath(StationDB.getInstance().getStation(src),
//            StationDB.getInstance().getStation(dst));
//
//        ResponseList responseList = new ResponseList();
//
//        responseList.setList(cityList);
//
//        return responseList;
//    }
//}
