package io.pragra.learning.springdatajpademo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bankDetailId;
    private String accountNumber;
    private String bankName;

    @Override
    public String toString() {
        return "BankDetails{" +
                "bankDetailId=" + bankDetailId +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }

    public Integer getBankDetailId() {
        return bankDetailId;
    }

    public void setBankDetailId(Integer bankDetailId) {
        this.bankDetailId = bankDetailId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
