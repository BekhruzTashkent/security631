package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
