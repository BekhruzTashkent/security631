package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Product_Properties;


public interface ProductPropertiesRepository extends JpaRepository<Product_Properties, Integer> {
}
