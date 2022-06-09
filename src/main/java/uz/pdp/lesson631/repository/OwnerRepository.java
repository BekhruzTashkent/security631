package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Owner;


public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
