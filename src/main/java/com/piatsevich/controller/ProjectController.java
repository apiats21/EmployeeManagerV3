package com.piatsevich.controller;


import com.piatsevich.model.Project;
import com.piatsevich.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProjects(Model model){
        model.addAttribute("projects", this.projectService.getAll());

        return "project/list-project";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Project project = new Project();

        model.addAttribute("project", project);
        return "project/project-form";
    }

    @RequestMapping(value = "/showFormForUpdate", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("project_id") Integer id, Model model) {
        Project project = projectService.getById(id);
        model.addAttribute("project", project);

        return "project/project-form";
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
    public String deleteProject(@RequestParam("project_id") Integer id) {
        this.projectService.delete(id);
        return "redirect:/projects/list";
    }

    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("project") Project project) {
        projectService.create(project);
        return "redirect:/projects/list";
    }
}