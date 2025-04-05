package io.pragra.learning.springdatajpademo.service;

import io.pragra.learning.springdatajpademo.model.Employee;
import io.pragra.learning.springdatajpademo.repository.AddressRepo;
import io.pragra.learning.springdatajpademo.repository.BankDetailsRepo;
import io.pragra.learning.springdatajpademo.repository.EmployeeRepo;
import io.pragra.learning.springdatajpademo.repository.HealthInsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrganizationService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    BankDetailsRepo bankDetailsRepo;

    @Autowired
    HealthInsuranceRepo healthInsuranceRepo;

    public Employee joinOrganization(Employee employee) {
        System.out.println(employee);
        // save transient instance
        addressRepo.save(employee.getAddress());
        bankDetailsRepo.saveAll(employee.getBankDetails());
        return employeeRepo.save(employee);

        // also implement register for insurance benefits method


    }

    public Employee addEmployee(Employee employee) {
        System.out.println(employee);
        // save transient instance
        addressRepo.save(employee.getAddress());
        bankDetailsRepo.saveAll(employee.getBankDetails());
        return employeeRepo.save(employee);
    }
}
