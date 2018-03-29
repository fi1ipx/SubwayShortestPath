/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscowsubway.impls;

import com.moscowsubway.objects.ShortestPath;
import com.moscowsubway.database.EdgesDB;
import com.moscowsubway.database.LineDB;
import com.moscowsubway.database.StationDB;
import com.moscowsubway.interfaces.ObjectsLists;
import com.moscowsubway.interfaces.Path;
import java.util.ArrayList;
import java.util.Collections;
import javax.jws.WebService;
import com.moscowsubway.objects.Edge;
import com.moscowsubway.objects.Line;
import com.moscowsubway.objects.Station;

@WebService(serviceName = "SubwayService")
public class ObjectsListsImpl  implements ObjectsLists, Path{
    @Override
    public ArrayList<Station> getStations() {
        ArrayList<Station> list = new ArrayList<>();
        list = StationDB.getInstance().getAllStations();
        return list;
    }
    
    @Override
    public ArrayList<Line> getLines() {
        ArrayList<Line> list = new ArrayList<>();
        list = LineDB.getInstance().getAllLines();
        return list;
    }
    
    @Override
    public ArrayList<Station> getPath(Station src, Station dst) {
        ArrayList<Station> list = new ArrayList<>();
        list.addAll(getPath(src.getId(), dst.getId()));
        return list;
    }
    
    public ObjectsListsImpl() {
    }
    
    private ArrayList<Station> getPath(int src, int dst) {
        ArrayList<Edge> edges = EdgesDB.getInstance().getAllEdges();
        int w = 1;
        int graph[][] = new int[249][249];
        for (int i = 0; i < edges.size(); i++) {
            int st1 = 0, st2 = 0;
            st1 = edges.get(i).getSrc() - 1;
            st2 = edges.get(i).getDst() - 1;
            graph[st1][st2] = w;
            graph[st2][st1] = w;
        }
        ShortestPath t = new ShortestPath();
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<Integer> st_ids = new ArrayList<>();
        st_ids = t.dijkstra(graph, src-1, dst-1);
        for (int i = 0; i < st_ids.size(); i++)
            stations.add(StationDB.getInstance().getStation(st_ids.get(i)+1));
        Collections.reverse(stations);
        stations.add(StationDB.getInstance().getStation(dst));
        return stations;
    }
}
