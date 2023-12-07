package dat3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlRouteController {
    @GetMapping("")
    String index() {
        return "/html/pages/index/index.html";
    }

    @GetMapping("/index")
    String slashIndex() {
        return "/html/pages/index/index.html";
    }

    @GetMapping("about")
    String about() {
        return "/html/pages/about/about.html";
    }

    @GetMapping("contact")
    String contact() {
        return "/html/pages/contact/contact.html";
    }

    @GetMapping("privacypolicy")
    String privatepolicy() {return "/html/pages/contact/privacypolicy.html";}

    @GetMapping("typerating")
    String typerating() {
        return "/html/pages/typerating/typerating.html";
    }

    @GetMapping("a320")
    String a320() {
        return "/html/pages/typerating/a320.html";
    }

    @GetMapping("b737")
    String b737() {
        return "/html/pages/typerating/b737.html";
    }

    @GetMapping("b777")
    String b777() {
        return "/html/pages/typerating/b777.html";
    }

    @GetMapping("b787")
    String b787() {
        return "/html/pages/typerating/b787.html";
    }

    @GetMapping("lpc")
    String lpc() { return "/html/pages/lpc/lpc.html";}

    @GetMapping("sfitri")
    String sfitri() { return "/html/pages/sfitri/sfitri.html";}
    @GetMapping("courseContact")
    String courseContract() { return "/html/pages/courseContact/courseContact.html";}
}




