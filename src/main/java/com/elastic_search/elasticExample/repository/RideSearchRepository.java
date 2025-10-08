package com.elastic_search.elasticExample.repository;

import com.elastic_search.elasticExample.model.Ride;
import com.elastic_search.elasticExample.model.RideDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RideSearchRepository extends ElasticsearchRepository<RideDocument, String> {

    List<RideDocument> findByPickupLocationContainingOrDropLocationContaining(String pickup, String drop);
    List<RideDocument> findByStatus(String status);
}
