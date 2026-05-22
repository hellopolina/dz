package dz7.arena.app;

import dz7.arena.heroes.Archer;
import dz7.arena.heroes.Hero;
import dz7.arena.heroes.Knight;
import dz7.arena.heroes.Mage;

public class Main {

    public static void main(String[] args) {
        Hero[] heroes = {
                new Knight("Артур", 17, 100, 50),
                new Archer("Леголас", 67, 71, 43),
                new Mage("Колдун", 1, 17, 250)
        };

        for(Hero hero: heroes) {
            hero.printInfo();
            hero.attack();
        }

        final Knight knight = new Knight("The last of us", 99, 7, 12);
        System.out.println(knight);
        knight.setArmor(knight.getArmor() + 1);
        System.out.println(knight);
    }
}

