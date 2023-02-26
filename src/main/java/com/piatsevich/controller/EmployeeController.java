package com.piatsevich.controller;

import com.piatsevich.model.Employee;
import com.piatsevich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(Model model){
        model.addAttribute("employees", this.employeeService.getAll());

        return "employee/list-employee";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "employee/employee-form";
    }

    @RequestMapping(value = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("employee_id") Integer id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);

        return "employee/employee-form";
    }

//    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
//    public String addEmployee(@ModelAttribute("employee") Employee employee) {
//        if(employee.getId() == 0) {
//            this.employeeService.create(employee);
//        } else {
//            this.employeeService.update(employee);
//        }
//        return "redirect:/";
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam("employee_id") Integer id) {
        this.employeeService.delete(id);
        return "redirect:/employees/list";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.create(employee);
        return "redirect:/employees/list";
    }
}