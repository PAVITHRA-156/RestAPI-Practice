package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.demo.Model.Product;
import springboot.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService obj;

    @PostMapping("/post")
    public ResponseEntity<Product> addProduct(@RequestBody Product a) {
        return new ResponseEntity<>(obj.addProduct(a), HttpStatus.CREATED);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = obj.getProductById(id);
        return product != null ? new ResponseEntity<>(product, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(obj.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/updating/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = obj.editProduct(id, updatedProduct.getProductname(), updatedProduct.getDescription());
        return product != null ? new ResponseEntity<>(product, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProducts(@PathVariable int id) {
        return obj.deleteProducts(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ✅ Pagination Only
    @GetMapping("/page")
    public ResponseEntity<List<Product>> getProductsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(obj.getProductsByPage(page, size), HttpStatus.OK);
    }

    // ✅ Sorting Only
    @GetMapping("/sort")
    public ResponseEntity<List<Product>> getSortedProducts(@RequestParam String field) {
        return new ResponseEntity<>(obj.getSortedProducts(field), HttpStatus.OK);
    }

    // ✅ Pagination + Sorting
    @GetMapping("/pageandsort")
    public ResponseEntity<List<Product>> getProductsByPageAndSort(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam String field) {
        return new ResponseEntity<>(obj.getProductsByPageAndSort(page, size, field), HttpStatus.OK);
    }
}
