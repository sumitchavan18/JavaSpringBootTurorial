package net.javasum.ems.product.employee_management.service.interfaces;


import net.javasum.ems.product.employee_management.dto.EmployeeDto;
import net.javasum.ems.product.employee_management.entity.Employee;
import net.javasum.ems.product.employee_management.model.response.CreateEmployeeResp;

import java.util.List;

public interface EmployeeService {
    CreateEmployeeResp createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    Long deleteEmployeeById(Long id);
    EmployeeDto updateEmployeeDetails(Long id, EmployeeDto employeeDto);
;}
