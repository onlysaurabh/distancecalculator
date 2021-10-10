package com.assignment.distancecalculation.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author Saurabh Shekhawat
 * Class DistanceCalculatorController
 *  Controller to calculate distance
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/api/distancecalculator")
@Slf4j
public class DistanceCalculatorController {

    /**
     * Post method to calculate
     * @param RequestBody
     * @return  ResponseEntity<String>
     */
    @PostMapping(path = "/calculate")
    public ResponseEntity<String> calculate(@RequestBody com.assignment.distancecalculation.model.RequestBody request) {
        String firstInput = String.valueOf(checkAndConvertUnit(request.getFirstDistance()));
        String secondInput =  String.valueOf(checkAndConvertUnit(request.getSecondDistance()));

        double output = Double.sum(Double.parseDouble(firstInput),Double.parseDouble(secondInput));
        return ResponseEntity.ok("Total Distance is "+output+" METERS");
    }

    /**
     * method to check the whether input is meter or if not convert
     * @param String
     * @return  double
     */
    private double checkAndConvertUnit(String input){
        int spacePos = input.indexOf(" ");
        double distance = Double.parseDouble(input.substring(0,input.indexOf(" ")));
        String unit  = input.substring(spacePos+1,input.length()).trim();

        final double YARDS = 0.9144;
        double convertedValue = 0;
        String convertedUnit ="METERS";
        if(unit.equalsIgnoreCase("YARDS")){
            convertedValue = distance*YARDS;
        }else if(unit.equalsIgnoreCase("METERS")){
            convertedValue = distance;
        }
        return convertedValue;
    }
}
