package io.pragra.learning.springdatajpademo.api;

import io.pragra.learning.springdatajpademo.model.Employee;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.pragra.learning.springdatajpademo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/addAll")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    @GetMapping("/getById")
    public Optional<Employee> getEmployeeById(@RequestParam Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getFnameById")
    public String getFnameById(@RequestParam Long id) {
        return employeeService.getEmployeeById(id).get().getFirstName();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteEmployee")
    public Employee deleteEmployee(@RequestParam Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PatchMapping("/patchEmployee")
    public Employee patchEmployee(@RequestBody Employee employee) {
        return employeeService.patchEmployee(employee);
    }

    @GetMapping("/getAllByFirstName")
    public List<Employee> getEmployeeByFirstName(@RequestParam String firstName) {
        return employeeService.getEmployeesByFirstName(firstName);
    }

    @GetMapping("/getAllByLastName")
    public List<Employee> getEmployeeByLastName(@RequestParam String lastName) {
        return employeeService.getEmployeesByLastName(lastName);
    }

    @GetMapping("/getAllByDesignation")
    public List<Employee> getEmployeesByDesignation(@RequestParam String designation) {
        return employeeService.getEmployeesByDesignation(designation);
    }
}
