package com.tms.mono.model;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import com.tms.mono.enums.Status;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
public class Consighnment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nonnull
	@OneToOne(mappedBy = "consighnment", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "consighnment_owner")
	private ConsighnmentOwner consighnmentOwner; // One consignment has one owner
	@Nonnull
	@Column(name = "type")
	private String type;
	
	@Nonnull
	@Column(name = "startingPlace")
	@NotBlank
	private String startingPlace;
	
	@Nonnull
	@Column(name = "destination")
	@NotBlank
	private String destination;
	
	@Nonnull
	@Column(name = "load_weight")
	@NotBlank
	private Double loadWeight;
	@Nonnull
	@Column(name = "fare")
	private Double fare;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="status")
	private Status status;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "route")
	private Route route;

	@OneToOne
	private AssignedConsighnmentsDetails consighnmentsDetails;
}
