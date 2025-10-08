package com.elastic_search.elasticExample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @Field(name = "ride_id")
    private int rideId;

    @Field(name = "rider_id")
    private int riderId;

    @Field(name = "driver_id")
    private int driverId;

    @Field(name = "vehicle_id")
    private int vehicleId;

    @Field(name = "pickup_location")
    private String pickupLocation;

    @Field(name = "drop_location")
    private String dropLocation;

    private String status;
    private double fare;

    @Field(name = "ride_date")
    private LocalDateTime rideDate;

    private Payment payment;
    private List<Rating> ratings;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payment {

        private double amount;
        private String method;
        private String status;

        @Field(name = "payment_date")
        private LocalDateTime paymentDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rating {

        @Field(name = "given_by")
        private int givenBy;

        @Field(name = "given_to")
        private int givenTo;

        private int score;
        private String comment;
    }
}
