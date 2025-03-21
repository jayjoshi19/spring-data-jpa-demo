package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class JobsApplied {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobId;
    private Integer studentId;
    private Integer jobApplicationId;
}
