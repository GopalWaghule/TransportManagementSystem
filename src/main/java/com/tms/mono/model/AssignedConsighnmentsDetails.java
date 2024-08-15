package com.tms.mono.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tms.mono.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assigned_consighnments_details")
public class AssignedConsighnmentsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy ="consighnmentsDetails", cascade = CascadeType.ALL)
	@JsonBackReference
	private Consighnment consighnment;
	
	@OneToOne(mappedBy = "assighnment")
	@JoinColumn(name = "vehical")
	private Vehical vehical;
	
	@Column(name = "total_fair")
	private Double totalFair;
	@Column(name = "advance")
	private Double advance;
	@Column(name = "remaining_fair")
	private Double remainingFair;
	@Column(name = "status")
	private Status status;
	
	@CreationTimestamp
    @Column(name = "start_date", updatable = false)
	private LocalDate startDate; 
	
}
