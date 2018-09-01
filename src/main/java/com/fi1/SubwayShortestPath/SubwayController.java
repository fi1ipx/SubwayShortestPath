package com.fi1.SubwayShortestPath;

import com.fi1.SubwayShortestPath.objects.Edge;
import com.fi1.SubwayShortestPath.objects.Line;
import com.fi1.SubwayShortestPath.objects.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubwayController {

    private SubwayService subwayService;

    @RequestMapping("stations")
    public List<Station> getAllStations() {
        return subwayService.getAllStations();
    }

    @RequestMapping("lines")
    public List<Line> getAllLines() {
        return subwayService.getAllLines();
    }

    @RequestMapping("edges")
    public List<Edge> getAllEdges() {
        return subwayService.getAllEdges();
    }

    @RequestMapping("path")
    public List<Station> getPath(@RequestParam("src") int src, @RequestParam("dst") int dst) {
        return subwayService.getPath(src, dst);
    }

    @Autowired
    public void setSubwayService(SubwayService subwayService) {
        this.subwayService = subwayService;
    }
}
