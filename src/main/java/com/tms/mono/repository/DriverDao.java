package com.tms.mono.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.mono.model.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Serializable>{

}
