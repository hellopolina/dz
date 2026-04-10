public static void main(String[] args) {
        String name = "Эдуардо";
        String position = "Пекарь";
        int shiftRate = 1000;
        int numberOfShifts = 20;
        int bonus = 2000;
        int penalty = 1500;
        int priceOfShaverma = 250;
        int numberOfShavermaSold = 500;

        System.out.println("Сотрудник: " + name + "\n"
                + "Должность: " + position + "\n"
                + "Оплата за смены: " + shiftRate * numberOfShifts + "\n"
                + "Премия: " + bonus + "\n"
                + "Штраф: " + penalty + "\n"
                + "Итоговая зарплата: " + (shiftRate * numberOfShifts + bonus - penalty) + "\n"
                + "Шавермная выручка: " + priceOfShaverma * numberOfShavermaSold);
}