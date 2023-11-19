package dat3.rename_me.api;

//This class was made entirely to test the CI/CD pipeline works

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lol")
public class ActionsTestController {

@GetMapping()
    String test(){
    return "det VIRKER!";
}

}
