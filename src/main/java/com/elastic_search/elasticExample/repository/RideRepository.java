package com.elastic_search.elasticExample.repository;

import com.elastic_search.elasticExample.model.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<Ride, String> {
}
