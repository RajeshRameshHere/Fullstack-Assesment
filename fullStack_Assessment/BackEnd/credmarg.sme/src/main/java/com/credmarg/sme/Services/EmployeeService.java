package com.credmarg.sme.Services;

import com.credmarg.sme.Entity.Employee;
import com.credmarg.sme.Payload.EmployeeDTO;
import com.credmarg.sme.Payload.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO saveOneEmployee(EmployeeDTO employeeDTO);
    public EmployeeResponse showAllEmployee();
}
