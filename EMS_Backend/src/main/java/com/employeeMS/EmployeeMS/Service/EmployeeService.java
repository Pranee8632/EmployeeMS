package com.employeeMS.EmployeeMS.Service;


import com.employeeMS.EmployeeMS.Entity.Employee;
import com.employeeMS.EmployeeMS.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    public void deleteEmployee(Long id)
    {
        if(!employeeRepository.existsById(Math.toIntExact(id)))
        {
            throw new EntityNotFoundException("Employee with If "+ id +"not found");
        }

        employeeRepository.deleteById(Math.toIntExact(id));
    }


    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employee)
    {
        Optional<Employee> optionalEmployee = employeeRepository.findById(Math.toIntExact(id));
        if(optionalEmployee.isPresent())
        {
            Employee existingEmployee = optionalEmployee.get();

            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartment(employee.getDepartment());

            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
