package com.fi1.SubwayShortestPath;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fi1.SubwayShortestPath.database.EdgeRepository;
import com.fi1.SubwayShortestPath.database.LineRepository;
import com.fi1.SubwayShortestPath.database.StationRepository;
import com.fi1.SubwayShortestPath.objects.Edge;
import com.fi1.SubwayShortestPath.objects.Line;
import com.fi1.SubwayShortestPath.objects.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class StartupComponent {

    private StationRepository stationRepository;
    private EdgeRepository edgeRepository;
    private LineRepository lineRepository;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        File stationsFile = new ClassPathResource("stations.json").getFile();
        List<Station> stationList = jsonMapper.readValue(stationsFile, new TypeReference<List<Station>>() {});
        stationRepository.saveAll(stationList);

        File edgesFile = new ClassPathResource("edges.json").getFile();
        List<Edge> edgeList = jsonMapper.readValue(edgesFile, new TypeReference<List<Edge>>() {});
        edgeRepository.saveAll(edgeList);

        File linesFile = new ClassPathResource("lines.json").getFile();
        List<Line> lineList = jsonMapper.readValue(linesFile, new TypeReference<List<Line>>() {});
        lineRepository.saveAll(lineList);
    }

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Autowired
    public void setEdgeRepository(EdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }

    @Autowired
    public void setLineRepository(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
