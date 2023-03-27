package com.springboot.payrollApp.entity;

import com.springboot.payrollApp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column
    private String name;

    @Column
    private String salary;
    @Column
    private String gender;
    @Column
    private String notes;
    @Column
    private String startDate;
    @Column
    private String department;


    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.department = employeeDTO.getDepartment();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.notes = employeeDTO.getNotes();
        this.startDate = employeeDTO.getStartDate();
    }
}
