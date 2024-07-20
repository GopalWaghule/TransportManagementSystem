package com.tms.mono.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
public class Vehical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;
    @Column(name = "total_capacity")
    private String totalCapacity;
    @Column(name = "remaining_capacity")
    private Double remainingCapacity;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "owner")
    private VehicalOwner owner;

    @OneToMany(mappedBy = "vehicals", cascade = CascadeType.ALL)
    @Column(name = "drivers")
    private List<Driver> drivers;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "route")
    private Route route;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "assighnment")
    private AssignedConsighnmentsDetails assighnment;
}
