package com.employeeMS.EmployeeMS.Repository;

import com.employeeMS.EmployeeMS.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
