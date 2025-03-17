package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepo extends JpaRepository<BankDetails, Integer> {
}
