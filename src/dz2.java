import java.util.Random;

public class dz2 {

    public static void main(String[] args) {
        Random random = new Random();

        int age = random.nextInt(0, 70);
        double money = random.nextDouble(100, 10000000);
        boolean hasInvitation = true;
        boolean isInBlackList = false;
        double contribution = money * 0.075;

        boolean adult = age >= 18;
        boolean hasInvitationMoney = hasInvitation || money > 50000;

        boolean decision = (adult && hasInvitationMoney && !isInBlackList) ? true : false;

        String answer = decision ? "Да" : "Нет";

        System.out.println(
                "Возраст участника: " + age + "\n"
                        + "Сумма денег на счёте: " + money + "\n"
                        + "Наличие приглашения: " + hasInvitation + "\n"
                        + "Наличие в черном списке: " + isInBlackList + "\n"
                        + "Пользователь проходит? " + answer + "\n"
                        + "Обязательный добровольный взнос: " + contribution
        );
    }
}