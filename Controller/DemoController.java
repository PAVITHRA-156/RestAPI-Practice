package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/")
   public String ownerName()
   {
    return "hello world";
   }
   //RequestPAram
   @GetMapping("/abc")
  public String method(@RequestParam String sn,@RequestParam int age)
  {
    return "welcome "+sn+" "+age;
  }
  //pathVariable
  @GetMapping("/name/{name}")
  public String method1(@PathVariable String name)
  {
    return "Welcome "+name;
  }
  @Value("${app.name}")
  private String appname;
  @GetMapping("/appname")
  public String value()
  {
    return appname;
  }

}
