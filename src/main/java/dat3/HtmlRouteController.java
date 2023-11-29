package dat3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlRouteController {
    @GetMapping("")
    String index() {
        return "index.html";
    }

    @GetMapping("/index")
    String slashIndex() {
        return "index.html";
    }

    @GetMapping("about")
    String about() {
        return "about.html";
    }

    @GetMapping("contact")
    String contact() {
        return "contact.html";
    }

    @GetMapping("typerating")
    String typerating() {
        return "typerating.html";
    }

    @GetMapping("a320")
    String a320() {
        return "a320.html";
    }

    @GetMapping("b737")
    String b737() {
        return "b737.html";
    }

    @GetMapping("b777")
    String b777() {
        return "b777.html";
    }

    @GetMapping("b787")
    String b787() {
        return "b787.html";
    }
}




