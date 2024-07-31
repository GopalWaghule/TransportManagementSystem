package com.tms.mono.model.dto;

import java.util.List;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Vehical;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDTO {
    private Long id;
    private String routeName;
    private String startLocation;
    private String destination;
    private List<Consighnment> consighnments; 
    private List<Vehical> vehicals; 

}