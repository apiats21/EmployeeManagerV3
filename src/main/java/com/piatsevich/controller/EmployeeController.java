package com.piatsevich.controller;

import com.piatsevich.model.Department;
import com.piatsevich.model.Employee;
import com.piatsevich.service.DepartmentService;
import com.piatsevich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

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
//        Department department = departmentService.getById(employee.getDepartment().getId());
//        employee.setDepartment(department);
        model.addAttribute("employee", employee);

        return "employee/employee-form";
    }

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