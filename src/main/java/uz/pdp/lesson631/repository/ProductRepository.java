package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
