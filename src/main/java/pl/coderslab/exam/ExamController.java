package pl.coderslab.exam;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ExamController {
    private final HeroComponent heroComponent;

    public ExamController(HeroComponent heroComponent) {
        this.heroComponent = heroComponent;
    }

    @GetMapping("add-hero")
    public String addHero() {
        return "addHero";
    }

    @PostMapping("add-hero")
    public String hero(Model model, @RequestParam(name = "name") String name,
                       @RequestParam(name = "power") Long power,
                       @RequestParam(name="birth")
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfbirth,
                       @RequestParam(name = "phone") String phoneNumber) {
        Hero newHero = new Hero(name, power, dateOfbirth, phoneNumber);
        heroComponent.addHero(newHero);
        model.addAttribute("newHero", newHero);
        return "showHero";
    }

    @GetMapping("hero-list")
    public String heroList(Model model){
        Map<String,Integer> heroes =  heroComponent.getListOfHeroes().stream()
                .filter(s->s.getDateOfbirth().getYear()>2000)
                .collect(Collectors.toMap(
                        Hero::getName,
                        s-> Period.between(s.getDateOfbirth(),LocalDate.now()).getYears())
                );

        model.addAttribute("heroes", heroes);
        return "heroes";

    }

}
