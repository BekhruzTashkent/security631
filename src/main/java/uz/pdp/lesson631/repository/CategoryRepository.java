package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
