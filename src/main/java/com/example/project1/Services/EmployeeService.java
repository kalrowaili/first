package com.example.project1.Services;

import com.example.project1.Entites.Employee;
import com.example.project1.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }
    public void addEmployee(Employee employee) {employeeRepository.save(employee);}
    public void deleteEmployee(Integer employeeId) {employeeRepository.deleteById(employeeId);}
}
