package com.credmarg.sme.ServicesImpl;

import com.credmarg.sme.Entity.Employee;
import com.credmarg.sme.Payload.EmployeeDTO;
import com.credmarg.sme.Payload.EmployeeResponse;
import com.credmarg.sme.Repository.EmployeeRepository;
import com.credmarg.sme.Services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;
   public EmployeeServiceImpl(EmployeeRepository employeeRepo){
        this.employeeRepo=employeeRepo;
    }
    @Override
    public EmployeeDTO saveOneEmployee(EmployeeDTO employeeDTO) {

        Employee employee = mapToEntity(employeeDTO);
        Employee savedEmployee = employeeRepo.save(employee);

        return maptoDTO(savedEmployee);
    }

    @Override
    public EmployeeResponse showAllEmployee() {
        List<Employee> allEmployees = employeeRepo.findAll();
        List<EmployeeDTO> allEmployeeDto = allEmployees.stream().map(e -> maptoDTO(e)).collect(Collectors.toList());

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setContents(allEmployeeDto);
        System.out.println(employeeResponse);

    return employeeResponse;
    }

    public Employee mapToEntity(EmployeeDTO employeeDTO){
        Employee newEmployee=new Employee();
        newEmployee.setName(employeeDTO.getName());
        newEmployee.setEmail(employeeDTO.getEmail());
        newEmployee.setDesignation(employeeDTO.getDesignation());
        newEmployee.setCtc(employeeDTO.getCtc());
        return newEmployee;
}
public EmployeeDTO maptoDTO(Employee employee){
       EmployeeDTO dto=new EmployeeDTO();
       dto.setName(employee.getName());
       dto.setEmail(employee.getEmail());
       dto.setDesignation(employee.getDesignation());
       dto.setCtc(employee.getCtc());
       return dto;
}
}
