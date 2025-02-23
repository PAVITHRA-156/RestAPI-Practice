package springboot.demo.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.demo.response.myResponse;

@RestController
public class message {
    @GetMapping("/jsonProof")
   public myResponse mess()
   {
    // myResponse r=new myResponse(id:1,firstname:"pavithra",lastname:"veluchamy");
    myResponse r=new myResponse(1, "pavithra", "veluchamy");
    return r;
   }
}
