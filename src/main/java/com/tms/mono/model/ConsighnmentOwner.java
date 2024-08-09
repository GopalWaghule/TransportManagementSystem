
package com.tms.mono.model;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsighnmentOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "consighnment")
    @JsonIgnore
    @JsonBackReference
    private Consighnment consighnment;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "company")
    private String company;
    @NotBlank
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "mobile1")
    private String mobile1;
}
