package com.elastic_search.elasticExample.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "rides")
public class Ride {

    @Id
    private String id;
    private int ride_id;
    private int rider_id;
    private int driver_id;
    private int vehicle_id;
    private String pickup_location;
    private String drop_location;
    private String status;
    private double fare;
    private LocalDateTime ride_date;

    private Payment payment;
    private List<Rating> ratings;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payment {
        private double amount;
        private String method;
        private String status;
        private LocalDateTime payment_date;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rating {
        private int given_by;
        private int given_to;
        private int score;
        private String comment;
    }
}