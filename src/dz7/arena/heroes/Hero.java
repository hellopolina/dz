package dz7.arena.heroes;

public class Hero {
    private String name;
    private int level;
    private int health;
    private final static int MAX_LEVEL = 100;
    private static int heroesCreated;

    public Hero(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
        heroesCreated++;
    }

    public void printInfo() {
        System.out.printf("- Имя героя: %s,\n- Уровень: %d,\n- Здоровье: %d,\n", name, level, health);
    }

    public void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void levelUp() {
        if (level < 100) level++;
        else level = MAX_LEVEL;
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар.");
    }

    public void attack(String target) {
        System.out.printf("Герой наносит обычный удар. Цель: %s", target);
    }

    public void attack(String target, int times) {
        System.out.printf("Герой атакует цель %s %d раза.", target, times);
    }

    public static void printHeroesCreated() {
        System.out.printf("Всего создано героев: %d", heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }

    @Override
    public String toString() {
        return "- Имя героя: " + name + "," + '\n' +
                "- Уровень: " + level + "," + '\n' +
                "- Здоровье: " + health;
    }
}

