package project_conten_02.prokhnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_conten_02.prokhnov.model.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {

    Component findByComponentName(String componentName);

    Component getComponentByComponentId(long id);
}
