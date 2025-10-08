package com.elastic_search.elasticExample;

import com.elastic_search.elasticExample.service.RideService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequiredArgsConstructor
public class ElasticExampleApplication {

    private final RideService rideService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticExampleApplication.class, args);
	}

    @PostConstruct
    public void init() {
        rideService.indexAllRidesBatch();
    }

}
