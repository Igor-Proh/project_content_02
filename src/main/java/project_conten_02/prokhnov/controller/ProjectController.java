package project_conten_02.prokhnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project_conten_02.prokhnov.model.Component;
import project_conten_02.prokhnov.model.Project;
import project_conten_02.prokhnov.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/projects")
//    @RolesAllowed(value = "ROLE_ADMIN")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @PostMapping(value = "/projects")
//    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    public Project createNewProject(@RequestBody Project project){
        projectService.saveProject(project);
        return project;
    }

    @PutMapping(value = "/projects")
//    @RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
    public Project updateProject(@RequestBody Project project){
        projectService.saveProject(project);
        return project;
    }

    @GetMapping(value = "/projects/{projectId}")
    public Project getProjectById(@PathVariable long projectId){
        return projectService.getById(projectId);
    }

    @DeleteMapping(value = "/projects/{projectId}")
//    @RolesAllowed("ROLE_EDITOR")
    public String deleteProjectById(@PathVariable long projectId){
        return projectService.deleteById(projectId);
    }

    @GetMapping(value = "/projects/sort")
    public List<Project> getListSortedBy(@RequestParam("sortBy") String sortBy){
        return projectService.sortBy(sortBy);
    }

    @PostMapping(value = "/projects/{projectId}/components")
    public Component addComponentToProject(@PathVariable long projectId, @RequestBody Component component){
        Project project = projectService.getById(projectId);
        project.addComponent(component);
        projectService.saveProject(project);
        return component;
    }

}
