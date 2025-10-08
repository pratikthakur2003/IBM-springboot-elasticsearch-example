package com.elastic_search.elasticExample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "rides_index")
public class RideDocument {

    @Id
    private String id;

    @Field(name = "ride_id", type = FieldType.Integer)
    private int rideId;

    @Field(name = "pickup_location", type = FieldType.Text)
    private String pickupLocation;

    @Field(name = "drop_location", type = FieldType.Text)
    private String dropLocation;

    @Field(type = FieldType.Keyword)
    private String status;

    @Field(type = FieldType.Double)
    private double fare;
}
