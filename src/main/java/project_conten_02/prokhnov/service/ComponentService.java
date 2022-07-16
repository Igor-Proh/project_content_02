package project_conten_02.prokhnov.service;

import project_conten_02.prokhnov.model.Component;

import java.util.List;

public interface ComponentService {
    Component findComponentByName(String componentName);

    void saveComponent(Component component);

    List<Component> findAll();

    List<Component> sortBy(String sortBy);

    Component getById(long id);

    String deleteById(long id);
}
