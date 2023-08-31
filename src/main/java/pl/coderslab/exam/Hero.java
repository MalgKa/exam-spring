package pl.coderslab.exam;

import java.io.Serializable;
import java.time.LocalDate;

public class Hero implements Comparable<Hero>, Serializable {
    private String name;
    private Long power;
    private LocalDate dateOfbirth;
    private String phoneNumber;


    public Hero(String name, Long power, LocalDate dateOfbirth, String phoneNumber) {
        this.name = name;
        this.power = power;
        this.dateOfbirth = dateOfbirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Hero otherHero) {
        if (this.power != null && otherHero.power != null) {
            return otherHero.power.compareTo(this.power);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", dateOfbirth=" + dateOfbirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
