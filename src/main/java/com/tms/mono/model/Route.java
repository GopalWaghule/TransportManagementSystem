package com.tms.mono.model;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "route_name")
    @NotBlank
    private String routeName;
    @Column(name = "startLocation")
    @NotBlank
    private String startLocation;
    @Column(name = "destination")
    @NotBlank
    private String destination;
    
    @OneToMany(mappedBy = "route")
    private List<Consighnment> consighnments; // One route can have many consignments

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    @Column(name = "vehicals")
    private List<Vehical> vehicals;
}