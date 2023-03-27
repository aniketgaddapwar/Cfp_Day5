package com.springboot.payrollApp.service;

import com.springboot.payrollApp.dto.EmployeeDTO;
import com.springboot.payrollApp.entity.Employee;
import com.springboot.payrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getall() {
        List<Employee> data = (List<Employee>) employeeRepository.findAll();
        return data;
    }

    @Override
    public Employee postDetails(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employeeRepository.findById(id).isPresent()){
            return employee;
        }
        else return null;
    }

    @Override
    public Employee updateById(EmployeeDTO employeeDTO, long id) {
        Employee employee = employeeRepository.findById(id).get();
        if (employeeRepository.findById(id).isPresent()) {
            employee.setName(employeeDTO.getName());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setSalary(employeeDTO.getSalary());
            employee.setNotes(employeeDTO.getNotes());
            employee.setGender(employeeDTO.getGender());
            employee.setStartDate(employeeDTO.getStartDate());
            employeeRepository.save(employee);
            return employee;
        }
        else return null;

    }

   public String deleteById(long id) {
       if (employeeRepository.findById(id).isPresent()) {
           employeeRepository.deleteById(id);
           return "Employee Info has been Deleted successfully!!";
       }
       else return null;
   }
}


