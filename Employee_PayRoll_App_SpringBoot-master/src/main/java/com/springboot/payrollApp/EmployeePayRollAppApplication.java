package com.springboot.payrollApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
 //used to create custom logs as this annotation helps to save, create custom logs by setting different msgs for logs like WARN,ERROR, DEBUG. in application.properties.
public class EmployeePayRollAppApplication {

	public static void main(String[] args) {SpringApplication.run(EmployeePayRollAppApplication.class, args);

	}
}
