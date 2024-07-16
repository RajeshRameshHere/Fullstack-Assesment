package com.credmarg.sme.Controller;

import com.credmarg.sme.Entity.Employee;
import com.credmarg.sme.Payload.EmployeeDTO;
import com.credmarg.sme.Payload.EmployeeResponse;
import com.credmarg.sme.ServicesImpl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3003/")
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO>saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO EmployeeDto = employeeService.saveOneEmployee(employeeDTO);
        return new ResponseEntity<>(EmployeeDto, HttpStatus.CREATED);
    }


    @GetMapping("/showall")
    public ResponseEntity<EmployeeResponse> listAllEmployees(){
        EmployeeResponse employeeResponse = employeeService.showAllEmployee();
        return new ResponseEntity<>(employeeResponse,HttpStatus.OK) ;
    }
}
