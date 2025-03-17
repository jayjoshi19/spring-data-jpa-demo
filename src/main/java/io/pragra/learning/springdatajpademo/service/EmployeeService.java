package io.pragra.learning.springdatajpademo.service;

import io.pragra.learning.springdatajpademo.model.Employee;
import io.pragra.learning.springdatajpademo.repository.AddressRepo;
import io.pragra.learning.springdatajpademo.repository.BankDetailsRepo;
import io.pragra.learning.springdatajpademo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    BankDetailsRepo bankDetailsRepo;

    public Employee addEmployee(Employee employee) {
        System.out.println(employee);
        // save transient instance
        addressRepo.save(employee.getAddress());
        bankDetailsRepo.saveAll(employee.getBankDetails());
        return employeeRepo.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee deleteEmployee(Long id) {
        Optional<Employee> opEmployee = employeeRepo.findById(id);
        if (opEmployee.isPresent()){
            Employee employee = opEmployee.get();
            employeeRepo.delete(employee);
            return employee;
        }
        return null;
    }

    public Employee updateEmployee(Employee updatedEmployee) {
        Optional<Employee> opEmployee = employeeRepo.findById(updatedEmployee.getEmployeeId());
        if (opEmployee.isPresent()){
            employeeRepo.save(updatedEmployee);
            return updatedEmployee;
        }
        return null;
    }

    public Employee patchEmployee(Employee updatedEmployee) {
        Optional<Employee> opEmployee = employeeRepo.findById(updatedEmployee.getEmployeeId());

        if (opEmployee.isPresent()){
            Employee empToPatch = opEmployee.get();
            empToPatch.setEmployeeId(updatedEmployee.getEmployeeId());

            if (Objects.nonNull(updatedEmployee.getFirstName())){
                empToPatch.setFirstName(updatedEmployee.getFirstName());
            }
            if (Objects.nonNull(updatedEmployee.getLastName())){
                empToPatch.setLastName(updatedEmployee.getLastName());
            }
            if (Objects.nonNull(updatedEmployee.getEmailId())){
                empToPatch.setEmailId(updatedEmployee.getEmailId());
            }

            employeeRepo.save(empToPatch);
            return empToPatch;
        }
        return null;
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    public List<Employee> getEmployeesByFirstName(String firstName) {
        return employeeRepo.findAllByFirstName(firstName);
    }

    public List<Employee> getEmployeesByLastName(String lastName) {
        return employeeRepo.findAllByLastName(lastName);
    }

    public List<Employee> getEmployeesByDesignation(String designation) {
        return employeeRepo.getAllByDesignation(designation);
    }
}
