package com.elastic_search.elasticExample.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "rides_index")
public class RideDocument {

    @Id
    private String id;
    private int rideId;
    private String pickupLocation;
    private String dropLocation;
    private String status;
    private double fare;
}
