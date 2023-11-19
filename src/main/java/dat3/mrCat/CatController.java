package dat3.mrCat;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    final
    CatRepository catRepository;

    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @GetMapping()
    String getCats() {
        return catRepository.findAll().toString();
    }

    @PostMapping("/addCat")
    String addCat(@RequestParam String name, @RequestParam String color){
        Cat cat = new Cat();
        cat.setName(name);
        cat.setColor(color);
        cat = catRepository.save(cat);
        return cat.toString();
    }

}
