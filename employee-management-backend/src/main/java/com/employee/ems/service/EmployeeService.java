package com.employee.ems.service;

import com.employee.ems.model.Employee;
import com.employee.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee emp = employeeRepository.findById(id).orElseThrow();
        emp.setName(updatedEmployee.getName());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setPhone(updatedEmployee.getPhone());
        emp.setDesignation(updatedEmployee.getDesignation());
        emp.setDepartment(updatedEmployee.getDepartment());
        emp.setJoiningDate(updatedEmployee.getJoiningDate());
        emp.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
