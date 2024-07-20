
package com.tms.mono.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
    @PrimaryKeyJoinColumn(name = "consighnment")
    private Consighnment consighnment;
    @Column(name = "name")
    private String name;
    @Column(name = "company")
    private String company;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "mobile1")
    private String mobile1;
}
