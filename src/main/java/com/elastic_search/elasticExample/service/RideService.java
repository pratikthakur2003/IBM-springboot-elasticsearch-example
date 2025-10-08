package com.elastic_search.elasticExample.service;


import com.elastic_search.elasticExample.model.Ride;
import com.elastic_search.elasticExample.model.RideDocument;
import com.elastic_search.elasticExample.repository.RideRepository;
import com.elastic_search.elasticExample.repository.RideSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final RideSearchRepository rideSearchRepository;

    private final static int BATCH_SIZE = 500;

    public void indexAllRidesBatch() {
        int page = 0;
        List<Ride> ridesBatch;

        do {
            ridesBatch = rideRepository.findAll(PageRequest.of(page, BATCH_SIZE)).getContent();
            if (!ridesBatch.isEmpty()) {
                List<RideDocument> documents = ridesBatch.stream()
                        .map(r -> RideDocument.builder()
                                .id(r.getId())
                                .rideId(r.getRideId())
                                .pickupLocation(r.getPickupLocation())
                                .dropLocation(r.getDropLocation())
                                .status(r.getStatus())
                                .fare(r.getFare())
                                .build())
                        .toList();

                rideSearchRepository.saveAll(documents);
                page++;
            }
        } while (!ridesBatch.isEmpty());

        System.out.println("All rides indexed into Elasticsearch successfully!");
    }

    public Ride saveRides(Ride ride) {
        Ride saved = rideRepository.save(ride);

        RideDocument doc = RideDocument.builder()
                .id(saved.getId())
                .rideId(saved.getRideId())
                .pickupLocation(saved.getPickupLocation())
                .dropLocation(saved.getDropLocation())
                .status(saved.getStatus())
                .fare(saved.getFare())
                .build();

        rideSearchRepository.save(doc);
        return saved;
    }

    public List<RideDocument> searchRides(String keyword) {
        return rideSearchRepository.findByPickupLocationContainingOrDropLocationContaining(keyword, keyword);
    }

    public List<RideDocument> searchByStatus(String status) {
        return rideSearchRepository.findByStatus(status);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
}
