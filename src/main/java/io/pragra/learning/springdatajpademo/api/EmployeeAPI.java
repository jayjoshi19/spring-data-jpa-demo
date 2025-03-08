package io.pragra.learning.springdatajpademo.api;

import io.pragra.learning.springdatajpademo.model.Employee;
import io.pragra.learning.springdatajpademo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }
}
