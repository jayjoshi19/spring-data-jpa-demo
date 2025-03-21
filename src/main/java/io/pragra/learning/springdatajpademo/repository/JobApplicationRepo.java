package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Integer> {
}
