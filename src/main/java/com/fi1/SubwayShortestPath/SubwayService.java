package com.fi1.SubwayShortestPath;

import com.fi1.SubwayShortestPath.database.EdgeRepository;
import com.fi1.SubwayShortestPath.database.LineRepository;
import com.fi1.SubwayShortestPath.database.StationRepository;
import com.fi1.SubwayShortestPath.objects.Edge;
import com.fi1.SubwayShortestPath.objects.Line;
import com.fi1.SubwayShortestPath.objects.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubwayService {

    private StationRepository stationRepository;
    private LineRepository lineRepository;
    private EdgeRepository edgeRepository;
    private PathComponent pathComponent;

    public List<Station> getAllStations() {
        List<Station> stationList = new ArrayList<>();
        stationRepository.findAll().forEach(stationList::add);
        return stationList;
    }

    public List<Line> getAllLines() {
        List<Line> lineList = new ArrayList<>();
        lineRepository.findAll().forEach(lineList::add);
        return lineList;
    }

    public List<Edge> getAllEdges() {
        List<Edge> edgeList = new ArrayList<>();
        edgeRepository.findAll().forEach(edgeList::add);
        return edgeList;
    }

    public List<Station> getPath(int src, int dst) {
        return pathComponent.getPath(src, dst);
    }

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Autowired
    public void setLineRepository(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @Autowired
    public void setEdgeRepository(EdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }

    @Autowired
    public void setPathComponent(PathComponent pathComponent) {
        this.pathComponent = pathComponent;
    }
}
