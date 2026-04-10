package esprit.candidat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatController {


    public String hello ="Hello from candidatMs";
    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }
}
