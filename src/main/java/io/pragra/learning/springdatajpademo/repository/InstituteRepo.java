package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepo extends JpaRepository<Institute, Integer> {
}
