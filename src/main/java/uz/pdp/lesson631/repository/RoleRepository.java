package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
}
