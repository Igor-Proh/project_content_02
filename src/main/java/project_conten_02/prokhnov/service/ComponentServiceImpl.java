package project_conten_02.prokhnov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_conten_02.prokhnov.exceptions.ComponentNotFoundException;
import project_conten_02.prokhnov.model.Component;
import project_conten_02.prokhnov.repository.ComponentRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public Component findComponentByName(String componentName) {
        return componentRepository.findByComponentName(componentName);
    }

    @Override
    public void saveComponent(Component component) {

        if (component.getComponentId() == 0) {
            component.setComponentCreateDate(new Date());
        } else if (component.getComponentId() != 0) {
            component.setComponentCreateDate(componentRepository.getComponentByComponentId(component.getComponentId()).getComponentCreateDate());
        }

        component.setComponentUpdateDate(new Date());
        componentRepository.save(component);
    }

    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public List<Component> sortBy(String sortBy) {

        List<Component> list = componentRepository.findAll();

        switch (sortBy) {
            case "id_asc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentId)).collect(Collectors.toList());
            case "id_desc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentId).reversed()).collect(Collectors.toList());
            case "name_asc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentName)).collect(Collectors.toList());
            case "name_desc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentName).reversed()).collect(Collectors.toList());
            case "description_asc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentDescription)).collect(Collectors.toList());
            case "description_desc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentDescription).reversed()).collect(Collectors.toList());
            case "date_asc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentCreateDate)).collect(Collectors.toList());
            case "date_desc":
                return list.stream().sorted(Comparator.comparing(Component::getComponentCreateDate).reversed()).collect(Collectors.toList());
            default:
                return list;
        }
    }

    @Override
    public Component getById(long id) {
        Component component = componentRepository.getComponentByComponentId(id);

        if (component == null) {
            throw new ComponentNotFoundException("Component with id - " + id + " is no found!!!");
        }

        return componentRepository.getComponentByComponentId(id);
    }

    @Override
    public String deleteById(long id) {
        Component component = componentRepository.getComponentByComponentId(id);

        if (component == null) {
            throw new ComponentNotFoundException("Component with id - " + id + " is no found!!!");
        }

        componentRepository.delete(component);

        return "Deleted project with id - " + id;
    }
}
