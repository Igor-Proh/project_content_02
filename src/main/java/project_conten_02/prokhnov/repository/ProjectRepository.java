package project_conten_02.prokhnov.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_conten_02.prokhnov.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectName(String projectName);

    Project getProjectByProjectId(long id);

}
