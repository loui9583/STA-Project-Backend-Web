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
}
