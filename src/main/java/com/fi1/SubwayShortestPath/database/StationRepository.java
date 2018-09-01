package com.fi1.SubwayShortestPath.database;

import com.fi1.SubwayShortestPath.objects.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<Station, Integer> {
}
