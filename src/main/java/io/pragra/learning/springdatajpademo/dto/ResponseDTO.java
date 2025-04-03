package io.pragra.learning.springdatajpademo.dto;

import io.pragra.learning.springdatajpademo.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
public class ResponseDTO {

    private Employee data;
    private String statusCode;
    private String statusDesc;


}
