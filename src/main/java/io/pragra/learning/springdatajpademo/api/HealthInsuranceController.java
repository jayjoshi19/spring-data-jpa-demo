package io.pragra.learning.springdatajpademo.api;


import io.pragra.learning.springdatajpademo.model.EmployeeHealthInsurance;
import io.pragra.learning.springdatajpademo.service.HealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/healthInsurance")
public class HealthInsuranceController {

    @Autowired
    HealthInsuranceService healthInsuranceService;

    @PostMapping("/register")
    public EmployeeHealthInsurance registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
        return healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
    }

    @DeleteMapping("/deleteById")
    public Optional<EmployeeHealthInsurance> deleteEmployeeHealthInsuranceById(Integer id) {
        return healthInsuranceService.deleteEmployeeHealthInsuranceById(id);
    }
}
