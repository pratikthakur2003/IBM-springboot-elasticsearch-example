package com.elastic_search.elasticExample.service;


import com.elastic_search.elasticExample.model.Ride;
import com.elastic_search.elasticExample.model.RideDocument;
import com.elastic_search.elasticExample.repository.RideRepository;
import com.elastic_search.elasticExample.repository.RideSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RideService {
    private final RideRepository rideRepository;
    private final RideSearchRepository rideSearchRepository;

    public Ride saveRides(Ride ride) {
        Ride saved = rideRepository.save(ride);

        RideDocument doc = RideDocument.builder()
                .id(saved.getId())
                .rideId(saved.getRide_id())
                .pickupLocation(saved.getPickup_location())
                .dropLocation(saved.getDrop_location())
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
