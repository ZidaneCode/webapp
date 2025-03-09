package com.rhapplication.webapp.service;

import com.rhapplication.webapp.model.Employee;
import com.rhapplication.webapp.repository.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(Integer id){
        return employeeProxy.getEmployee(id);
    }
    public Iterable<Employee> getAllEmployees(){
        return employeeProxy.getEmployees();
    }
    public Employee saveEmployee(Employee e){
        Employee savedEmployee;
        e.setLastName(e.getLastName().toUpperCase());
        if(e.getId()==null){
            savedEmployee =employeeProxy.ceateEmployee(e);
        }else{
            savedEmployee =employeeProxy.updateEmployee(e);
        }
        return savedEmployee;
    }
    public void deletEmployee(final  int id){
        employeeProxy.deleteEmployee(id);
    }
}
