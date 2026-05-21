package dz7.arena.heroes;

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
        knight.setArmor(13);
        System.out.println(knight);
    }
}

