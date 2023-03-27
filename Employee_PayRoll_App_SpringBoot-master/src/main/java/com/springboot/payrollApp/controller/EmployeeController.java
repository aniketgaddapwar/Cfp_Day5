package com.springboot.payrollApp.controller;

import com.springboot.payrollApp.dto.EmployeeDTO;
import com.springboot.payrollApp.dto.ResponseDTO;
import com.springboot.payrollApp.entity.Employee;
import com.springboot.payrollApp.service.EmployeeService;
import com.springboot.payrollApp.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/welcome")
    public String sayHello(){
        return "Welcome to Employee Pay Roll APP";
    }

//    http://localhost:8080/employee/welcome
    @GetMapping("/getemp")
    public ResponseEntity<ResponseDTO> allEmp(){
        List<Employee> employeeList =  employeeService.getall();
        ResponseDTO responseDTO = new ResponseDTO("All Details of Employees are found",employeeList);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
         }
    //http://localhost:8080/employee/postemp
    @PostMapping("/postemp")
   public ResponseEntity<ResponseDTO> postDetails(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.postDetails(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Added",employee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

   // http://localhost:8080/employee/getById/1
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id){
        Optional<Employee> employee = employeeService.getById(id);
        ResponseDTO responseDTO = new ResponseDTO("Details Found By "+id,employee);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }

//    http://localhost:8080/employee/update/2
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.updateById(employeeDTO,id);
        ResponseDTO responseDTO = new ResponseDTO("Data Upadated of" +id, employee);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

//    http://localhost:8080/employee/delete/2
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable long id){
        String msg = employeeService.deleteById(id);
        ResponseDTO responseDTO = new ResponseDTO("Data has Deleted", msg);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }
}
