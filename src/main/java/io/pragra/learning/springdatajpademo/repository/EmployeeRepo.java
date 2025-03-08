package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
