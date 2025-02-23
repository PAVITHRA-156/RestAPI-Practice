package springboot.demo.response;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class myResponse {
    // @JsonIgnore
int id; 
@Id
@JsonProperty("first_name")
String firstname;
String lastname;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getFirstname() {
    return firstname;
}
public void setFirstname(String firstname) {
    this.firstname = firstname;
}
public String getLastname() {
    return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}
public myResponse(int id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
}
}
