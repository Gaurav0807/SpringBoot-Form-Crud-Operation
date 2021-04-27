package com.start.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.start.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
