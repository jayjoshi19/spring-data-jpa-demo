package io.pragra.learning.springdatajpademo.service;

import io.pragra.learning.springdatajpademo.model.EmployeeHealthInsurance;
import io.pragra.learning.springdatajpademo.repository.HealthInsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthInsuranceService {

    @Autowired
    HealthInsuranceRepo healthInsuranceRepo;

    public EmployeeHealthInsurance registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
        return healthInsuranceRepo.save(employeeHealthInsurance);
    }

    public Optional<EmployeeHealthInsurance> deleteEmployeeHealthInsuranceById(Integer id) {
        return healthInsuranceRepo.findById(id);
    }
}
