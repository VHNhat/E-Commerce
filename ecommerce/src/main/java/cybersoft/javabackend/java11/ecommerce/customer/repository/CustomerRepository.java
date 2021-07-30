package cybersoft.javabackend.java11.ecommerce.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.ecommerce.customer.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
