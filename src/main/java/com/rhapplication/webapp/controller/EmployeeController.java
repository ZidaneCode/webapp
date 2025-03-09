package com.rhapplication.webapp.controller;

import com.rhapplication.webapp.model.Employee;
import com.rhapplication.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model){
        Iterable<Employee> listeEmployee=employeeService.getAllEmployees();
        model.addAttribute("employees",listeEmployee);
        return "home";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id){
        employeeService.deletEmployee(id);
        return new ModelAndView("redirect:/");
    }
}
