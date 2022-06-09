package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Payment_Customer;


public interface PaymentCustomerRepository extends JpaRepository<Payment_Customer, Integer> {
}
