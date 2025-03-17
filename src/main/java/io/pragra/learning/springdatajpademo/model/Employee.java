package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String designation;

    @OneToOne
    private Address address;
    @OneToMany
    private List<BankDetails> bankDetails;
}
