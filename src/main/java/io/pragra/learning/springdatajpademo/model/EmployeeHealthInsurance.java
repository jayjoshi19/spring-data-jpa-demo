package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeHealthInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer healthInsuranceId;
    private String healthInsuranceSchemeName;
    private int coverageAmount;
    @OneToOne
    Employee employee;

    @Override
    public String toString() {
        return "EmployeeHealthInsurance{" +
                "healthInsuranceId=" + healthInsuranceId +
                ", healthInsuranceSchemeName='" + healthInsuranceSchemeName + '\'' +
                ", coverageAmount=" + coverageAmount +
                ", employee=" + employee +
                '}';
    }

    public Integer getHealthInsuranceId() {
        return healthInsuranceId;
    }

    public void setHealthInsuranceId(Integer healthInsuranceId) {
        this.healthInsuranceId = healthInsuranceId;
    }

    public String getHealthInsuranceSchemeName() {
        return healthInsuranceSchemeName;
    }

    public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
        this.healthInsuranceSchemeName = healthInsuranceSchemeName;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
