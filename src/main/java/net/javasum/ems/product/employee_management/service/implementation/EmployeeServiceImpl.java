package net.javasum.ems.product.employee_management.service.implementation;

import lombok.AllArgsConstructor;
import net.javasum.ems.product.employee_management.dto.EmployeeDto;
import net.javasum.ems.product.employee_management.entity.Employee;
import net.javasum.ems.product.employee_management.exception.ResourceNotFoundException;
import net.javasum.ems.product.employee_management.mapper.EmployeeMapper;
import net.javasum.ems.product.employee_management.model.response.CreateEmployeeResp;
import net.javasum.ems.product.employee_management.repository.EmployeeRepository;
import net.javasum.ems.product.employee_management.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  // this annotation tells spring container to create spring bean for this class
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResp createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        employeeRepository.save(employee);

        return new CreateEmployeeResp("Sucess");
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Not Exists with the given Id :" + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long deleteEmployeeById(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Not Exists with the given Id :" + id));
        employeeRepository.deleteById(id);
        return id;
    }

    @Override
    public EmployeeDto updateEmployeeDetails(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Not Exists with the given Id :" + id));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployeeObject = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObject);
    }
}
