package net.javasum.ems.product.employee_management.repository;

import net.javasum.ems.product.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
