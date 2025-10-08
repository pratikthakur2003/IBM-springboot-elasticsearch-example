package com.elastic_search.elasticExample.controller;


import com.elastic_search.elasticExample.model.Ride;
import com.elastic_search.elasticExample.model.RideDocument;
import com.elastic_search.elasticExample.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
@RequiredArgsConstructor
public class RideController {
    private final RideService rideService;

    @PostMapping
    public Ride addRide(@RequestBody Ride ride) {
        return rideService.saveRides(ride);
    }

    @GetMapping("/search")
    public List<RideDocument> searchRides(@RequestParam String keyword) {
        return rideService.searchRides(keyword);
    }

    @GetMapping("/search/{status}")
    public List<RideDocument> searchByStatus(@PathVariable String status) {
        System.out.println("Status : " + status);
        return rideService.searchByStatus(status);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }


}
