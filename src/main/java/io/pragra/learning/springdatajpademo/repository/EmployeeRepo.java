package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFirstName(String firstName);

    List<Employee> findAllByLastName(String lastName);

    @Query("select e from Employee e where e.designation = ?1")
    List<Employee> getAllByDesignation(String designation);

    Employee findByLastName(String lastName);
}


