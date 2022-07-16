package project_conten_02.prokhnov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_conten_02.prokhnov.ProjectNotFoundException;
import project_conten_02.prokhnov.model.Project;
import project_conten_02.prokhnov.repository.ProjectRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public void saveProject(Project project) {
        if (project.getProjectId() == 0) {
            project.setProjectCreateDate(new Date());
        } else if (project.getProjectId() != 0) {
            project.setProjectCreateDate(projectRepository.getProjectByProjectId(project.getProjectId()).getProjectCreateDate());
        }

        project.setProjectUpdateDate(new Date());
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> sortBy(String sortBy) {

        List<Project> list = projectRepository.findAll();

        switch (sortBy) {
            case "id_asc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectId)).collect(Collectors.toList());
            case "id_desc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectId).reversed()).collect(Collectors.toList());
            case "name_asc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectName)).collect(Collectors.toList());
            case "name_desc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectName).reversed()).collect(Collectors.toList());
            case "description_asc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDescription)).collect(Collectors.toList());
            case "description_desc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectDescription).reversed()).collect(Collectors.toList());
            case "date_asc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectCreateDate)).collect(Collectors.toList());
            case "date_desc":
                return list.stream().sorted(Comparator.comparing(Project::getProjectCreateDate).reversed()).collect(Collectors.toList());
            default:
                return list;
        }
    }

    @Override
    public Project getById(long id) {

        Project project = projectRepository.getProjectByProjectId(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with id - " + id + " is no found!!!");
        }
        return projectRepository.getProjectByProjectId(id);
    }

    @Override
    public String deleteById(long id) {
        Project project = projectRepository.getProjectByProjectId(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with id - " + id + " is no found!!!");
        }

        projectRepository.delete(project);

        return "Deleted project with id - " + id;
    }


}
