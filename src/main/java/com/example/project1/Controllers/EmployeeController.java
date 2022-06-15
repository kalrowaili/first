package com.example.project1.Controllers;

import com.example.project1.Entites.Employee;
import com.example.project1.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    @GetMapping(path = "{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable(name = "employeeId") Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }
    @PostMapping(path= "add")
    public void registerNewEmployee(@RequestBody Employee employee){
        System.out.println(employee.toString());
        employeeService.addEmployee(employee);
    }
    @DeleteMapping(path = "delete/{employeeId}")
    public void deleteEmployee(@PathVariable ("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }
@PutMapping (path ="update/{employeeId}")
    public void updateEmployee(@PathVariable ("employeeId") Integer employeeId,@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
}
