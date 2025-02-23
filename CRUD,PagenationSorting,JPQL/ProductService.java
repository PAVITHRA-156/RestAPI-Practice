package springboot.demo.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.Model.Product;
import springboot.demo.Repository.ProductRepo2;
@Service
public class ProductService {
    @Autowired
    ProductRepo2 obj;
    public Product addProduct(Product a)
    {
      return obj.save(a);
    }
    public Product getProductById(int productId) {
      return obj.findById(productId).orElse(null);
  }
  
  public List<Product> getAllProducts() {
      return obj.findAll();
  }
  
  public Product editProduct(int productId, String productName, String description) {
      Product existingProduct = obj.findById(productId).orElse(null);
      if (existingProduct != null) {
          existingProduct.setProductname(productName);
          existingProduct.setDescription(description);
          return obj.save(existingProduct);
      } else {
          return null;
      }
  }
  
  public boolean deleteProducts(int id) {
    if (obj.existsById(id)) {
        obj.deleteById(id);
        return true;
    }
    return false;
}
      
public List<Product>getProductsByPage(int pageNumber,int pageSize)
{
    Pageable pageable=PageRequest.of(pageNumber, pageSize);
    return obj.findAll(pageable).getContent();
}

public List<Product>getSortedProducts(String field)
{
    return obj.findAll(Sort.by(Sort.Direction.ASC,field));
}
public List<Product>getProductsByPageAndSort(int pageNumber,int pageSize,String field)
{
   Page<Product> pageResult=obj.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(field)));
   return pageResult.getContent();
}

}
