package com.example.demo.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    //DependecyInjection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString()); // Giving a random code to employee
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) throws UserNotFoundException {
               return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteEmployee(Long id){
        log.info("inside delete mathod");
        employeeRepository.deleteById(id);
    }

}
