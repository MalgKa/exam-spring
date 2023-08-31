package pl.coderslab.exam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainHero {
    //zad 2
    public static void main(String[] args) {
        List<Hero> listOfHeroes = List.of(
                new Hero("Loki", 25000L, LocalDate.of(1855, 10, 15), "60176695"),
                new Hero("Venom", 15000L, LocalDate.of(1555, 8, 3), "176698541"),
                new Hero("black Widow", 900L, LocalDate.of(1984, 11, 22), "999-888-7777"),
                new Hero("Spider-Man", 800L, LocalDate.of(2001, 8, 10), "555-123-4567"),
                new Hero("Tony-Stark", 8000L, LocalDate.of(1888, 5, 29), "777-144-4567"),
                new Hero("Ultimus", 5000L, LocalDate.of(2003, 8, 10), "165-123-1239"),
                new Hero("Ultragirl", 500L, LocalDate.of(1996, 11, 3), "656-132-1897")
        );


        String chosenHeroes = listOfHeroes.stream()
                .filter(s -> s.getName().charAt(1) == 'l')
                .filter(s -> s.getPower() > 700)
                .sorted()
                .map(s -> s.getName().toUpperCase().charAt(0))
                .map(Object::toString)
                .collect(Collectors.joining("-"));
        System.out.println(chosenHeroes);

//zad 3

        HeroComponent heroComponent = new HeroComponent();
        heroComponent.addHero(new Hero("Tony-Stark", 8000L, LocalDate.of(1888, 5, 29), "777-144-4567"));
        heroComponent.addHero(new Hero("Ultimus", 5000L, LocalDate.of(2003, 8, 10), "165-123-1239"));

        System.out.println(heroComponent.findHeroByPhoneNumber("165-123-1239").orElse(null));
        System.out.println(heroComponent.findHeroByPhoneNumber("555").orElse(null));


    }
}
