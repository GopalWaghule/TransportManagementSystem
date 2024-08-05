package com.tms.mono.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assigned_consighnments_details")
public class AssignedConsighnmentsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy ="consighnmentsDetails", cascade = CascadeType.ALL)
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
	
	@CreatedDate
	@Column(name = "start_date")
	private LocalDate startDate; 
	
}
