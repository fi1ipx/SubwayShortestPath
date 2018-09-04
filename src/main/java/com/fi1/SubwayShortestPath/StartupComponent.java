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
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class StartupComponent {

    private StationRepository stationRepository;
    private EdgeRepository edgeRepository;
    private LineRepository lineRepository;
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        InputStream stationsStream = resourceLoader.getResource("classpath:stations.json").getInputStream();
        List<Station> stationList = jsonMapper.readValue(stationsStream, new TypeReference<List<Station>>() {});
        stationRepository.saveAll(stationList);

        InputStream edgesStream = resourceLoader.getResource("classpath:edges.json").getInputStream();
        List<Edge> edgeList = jsonMapper.readValue(edgesStream, new TypeReference<List<Edge>>() {});
        edgeRepository.saveAll(edgeList);

        InputStream linesStream = resourceLoader.getResource("classpath:lines.json").getInputStream();
        List<Line> lineList = jsonMapper.readValue(linesStream, new TypeReference<List<Line>>() {});
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

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
