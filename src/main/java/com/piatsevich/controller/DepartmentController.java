package com.piatsevich.controller;

import com.piatsevich.model.Department;
import com.piatsevich.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listDepartments(Model model){
        List<Department> list = departmentService.getAll();
        model.addAttribute("departments", this.departmentService.getAll());

        return "department/list-department";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Department department = new Department();

        model.addAttribute("department", department);
        return "department/department-form";
    }

    @RequestMapping(value = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("department_id") Integer id, Model model) {
        Department department = departmentService.getById(id);

        model.addAttribute("department", department);

        return "department/department-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam("department_id") Integer id) {
        this.departmentService.delete(id);
        return "redirect:/departments/list";
    }

    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.create(department);
        return "redirect:/departments/list";
    }
}
