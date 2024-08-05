package com.tms.mono.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "maker")
    private String maker;
    @Column(name = "model")
    private String model;
    @Column(name = "number")
    private String number;
    @Column(name = "totalCapacity")
    private Double totalCapacity;
    @Column(name = "remainingCapacity")
    private Double remainingCapacity;
    
    @ManyToOne
    @JoinColumn(name = "owner")
    private VehicalOwner owner;

    @OneToMany(mappedBy = "vehicals", cascade = CascadeType.ALL)
    @Column(name = "drivers")
    private List<Driver> drivers;

    @ManyToOne
    @JoinColumn(name = "route")
    private Route route;
    
    @OneToOne
    @JoinColumn(name = "assighnment")
    private AssignedConsighnmentsDetails assighnment;
}
