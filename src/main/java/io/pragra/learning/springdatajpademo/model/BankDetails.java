package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bankDetailId;
    private String accountNumber;
    private String bankName;

}
