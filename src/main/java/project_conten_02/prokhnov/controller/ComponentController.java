package project_conten_02.prokhnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project_conten_02.prokhnov.model.Component;
import project_conten_02.prokhnov.service.ComponentService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ComponentController {

    private final ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping(value = "/components")
    public List<Component> getAllComponents() {
        return componentService.findAll();
    }

    @PostMapping(value = "/components")
    public Component createNewComponent(@RequestBody Component component) {
        componentService.saveComponent(component);
        return component;
    }

    @PutMapping(value = "/components")
    @RolesAllowed({"ROLE_ADMIN"})
    public Component updateComponent(@RequestBody Component component) {
        componentService.saveComponent(component);
        return component;
    }

    @GetMapping(value = "/components/{componentId}")
    public Component getComponentById(@PathVariable long componentId) {
        return componentService.getById(componentId);
    }

    @DeleteMapping("/components/{componentId}")
    @RolesAllowed({"ROLE_ADMIN"})
    public String deleteComponentById(@PathVariable long componentId){
        return componentService.deleteById(componentId);
    }

    @GetMapping(value = "/components/sort")
    public List<Component> getListOfAllComponentsSortedBy(@RequestParam("sortBy") String sortBy){
        return componentService.sortBy(sortBy);
    }
}
