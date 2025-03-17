package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
