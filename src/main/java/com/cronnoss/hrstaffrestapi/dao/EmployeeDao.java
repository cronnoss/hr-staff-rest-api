package com.cronnoss.hrstaffrestapi.dao;

import com.cronnoss.hrstaffrestapi.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}