package com.tms.mono.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.mono.model.ConsighnmentOwner;

@Repository
public interface ConsighnmentOwnerDao extends JpaRepository<ConsighnmentOwner, Serializable> {

}
