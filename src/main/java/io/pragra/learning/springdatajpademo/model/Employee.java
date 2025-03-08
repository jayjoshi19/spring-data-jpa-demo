package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
}
