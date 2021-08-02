package cybersoft.javabackend.java11.ecommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.ecommerce.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
