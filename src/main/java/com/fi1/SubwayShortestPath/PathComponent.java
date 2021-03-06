package com.fi1.SubwayShortestPath;

import com.fi1.SubwayShortestPath.database.EdgeRepository;
import com.fi1.SubwayShortestPath.database.StationRepository;
import com.fi1.SubwayShortestPath.objects.Edge;
import com.fi1.SubwayShortestPath.objects.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PathComponent {

    private StationRepository stationRepository;
    private EdgeRepository edgeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PathComponent.class);

    public List<Station> getPath(int src, int dst) {
        List<Edge> edges = new ArrayList<>();
        edgeRepository.findAll().forEach(edges::add);
        int w = 1;
        int graph[][] = new int[250][250];
        for (int i = 0; i < edges.size(); i++) {
            int st1, st2;
            st1 = edges.get(i).getSrc() ;
            st2 = edges.get(i).getDst() ;
            graph[st1][st2] = w;
            graph[st2][st1] = w;
        }
        List<Station> stations = new ArrayList<>();
        List<Integer> st_ids = dijkstra(graph, src, dst);
        for (int i = 0; i < st_ids.size(); i++) {
            stationRepository.findById(st_ids.get(i)).ifPresent(stations::add);
        }
        Collections.reverse(stations);
        stationRepository.findById(dst).ifPresent(stations::add);
        LOGGER.info("Path between {} and {} calculated: {}", src, dst, stations);
        return stations;
    }

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    private static final int V = 250;
    private int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    private List<Integer> printSolution(int dist[], int preD[], int n, int dst) {
//        System.out.println("Vertex   Distance from Source");
//        for (int i = 0; i < V; i++)
//            System.out.println(i+" tt "+dist[i]);
        List<Integer> returnArray = new ArrayList<>();
        int j;
//        System.out.print("0000 = " + dst);
        j = dst;
        do
        {
            j = preD[j];
            if (j != 0)
                //System.out.print(" <- " + j);
                returnArray.add(j);
        }
        while(j != 0);
        return returnArray;
    }


    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    private List<Integer> dijkstra(int graph[][], int src, int dst) {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        int[] preD = new int[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    preD[v] = u;
                }
            }
        }

        // print the constructed distance array
        return printSolution(dist, preD, V, dst);
    }

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Autowired
    public void setEdgeRepository(EdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }
}
