package pl.coderslab.exam;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

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
}
