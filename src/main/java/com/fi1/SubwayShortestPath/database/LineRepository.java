package com.fi1.SubwayShortestPath.database;

import com.fi1.SubwayShortestPath.objects.Line;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends CrudRepository<Line, Integer> {
}
