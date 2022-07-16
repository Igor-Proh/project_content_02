package project_conten_02.prokhnov.service;

import project_conten_02.prokhnov.model.Project;

import java.util.List;

public interface ProjectService {
    Project findByProjectName(String projectName);

    void saveProject(Project project);

    List<Project> findAll();

    List<Project> sortBy(String sortBy);

    Project getById(long id);

    String deleteById(long id);
}
