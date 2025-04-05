package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.EmployeeHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsuranceRepo extends JpaRepository<EmployeeHealthInsurance, Integer> {
}
