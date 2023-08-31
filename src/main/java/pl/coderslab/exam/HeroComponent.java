package pl.coderslab.exam;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HeroComponent {
    private List<Hero> listOfHeroes = new ArrayList<>();


    public List<Hero> getListOfHeroes() {
        return listOfHeroes;
    }

    public void setListOfHeroes(List<Hero> listOfHeroes) {
        this.listOfHeroes = listOfHeroes;
    }

    public void addHero(Hero hero) {
        listOfHeroes.add(hero);
    }

    public Optional<Hero> findHeroByPhoneNumber(String phoneNumber) {
        return listOfHeroes.stream()
                .filter(h->h.getPhoneNumber().equals(phoneNumber))
                .findFirst();
    }

}
