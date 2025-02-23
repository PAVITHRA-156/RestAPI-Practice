package springboot.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
int productid;
String productname;
String description;
public int getProductid() {
    return productid;
}public void setProductid(int productid) {
    this.productid = productid;
}
public String getProductname() {
    return productname;
}
public void setProductname(String productname) {
    this.productname = productname;
}
public Product(int productid, String productname, String description) {
    this.productid = productid;
    this.productname = productname;
    this.description = description;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public Product() {
}

}
