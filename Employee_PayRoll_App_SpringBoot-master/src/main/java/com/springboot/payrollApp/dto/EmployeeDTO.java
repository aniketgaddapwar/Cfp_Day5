package com.springboot.payrollApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

//    private  long id;
    private String name;
    private String salary;
    private String gender;
    private String notes;
    private String startDate;
    private String department;


}
