package com.piatsevich.controller;

import com.piatsevich.model.Employee;
import com.piatsevich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(Model model){
//        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", this.employeeService.getAll());

        return "employee/list-employee";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if(employee.getId() == 0) {
            this.employeeService.create(employee);
        } else {
            this.employeeService.update(employee);
        }
        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") Integer id) {
        this.employeeService.delete(id);
        return "redirect:/employees";
    }
}