package project_conten_02.prokhnov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_conten_02.prokhnov.security.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
