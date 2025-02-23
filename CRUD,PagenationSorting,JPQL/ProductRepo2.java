package springboot.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springboot.demo.Model.Product;
@Repository
public interface ProductRepo2 extends JpaRepository<Product,Integer>
{
  
   @Query("SELECT p FROM Product p")
   public List<Product> getAllProducts();
}

