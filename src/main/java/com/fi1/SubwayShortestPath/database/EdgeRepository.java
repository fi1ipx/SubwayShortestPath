package com.fi1.SubwayShortestPath.database;

import com.fi1.SubwayShortestPath.objects.Edge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepository extends CrudRepository<Edge, Integer> {
}
