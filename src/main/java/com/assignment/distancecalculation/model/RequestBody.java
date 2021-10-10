package com.assignment.distancecalculation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestBody {

    @JsonProperty("first_distance")
    private String firstDistance;

    @JsonProperty("second_distance")
    private String secondDistance;


}
