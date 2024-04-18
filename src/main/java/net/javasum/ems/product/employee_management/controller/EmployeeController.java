package net.javasum.ems.product.employee_management.controller;

import lombok.AllArgsConstructor;
import net.javasum.ems.product.employee_management.dto.EmployeeDto;
import net.javasum.ems.product.employee_management.model.response.CreateEmployeeResp;
import net.javasum.ems.product.employee_management.service.interfaces.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController // after annotating with this annotation the class becomes spring mvc rest-controller, and
// it will be capable to handle http requests.
@RequestMapping("/api/employees") // to define the base url for all the rest apis that we are going to build in this controller
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee Rest API
    @PostMapping("/create")
    public ResponseEntity<CreateEmployeeResp> createEmployeeNew(@RequestBody EmployeeDto employeeDto ){
        CreateEmployeeResp savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED );
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee (){
        List<EmployeeDto> allEmployee = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteEmployeeById(@PathVariable("id") Long id){
        Long deletedEmployeeId = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(deletedEmployeeId);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeInfo = employeeService.updateEmployeeDetails(id, employeeDto);
        return ResponseEntity.ok(updatedEmployeeInfo);
    }
}
