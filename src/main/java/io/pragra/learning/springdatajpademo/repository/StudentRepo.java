package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
