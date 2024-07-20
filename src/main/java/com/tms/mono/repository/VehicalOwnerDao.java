package com.tms.mono.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.mono.model.VehicalOwner;

@Repository
public interface VehicalOwnerDao extends JpaRepository<VehicalOwner, Serializable> {

}
