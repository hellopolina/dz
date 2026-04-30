import java.util.Scanner;

public class dz4 {

    public static void main(String[] args) {

        //1 Строки: «Секретное послание древнего кода»

        Scanner scanner = new Scanner(System.in);

        String[] arr = new String[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextLine();
            if (arr[i].equalsIgnoreCase("NULL")) {
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
                arr[i] = "XX";
            }
        }

        StringBuilder message = new StringBuilder();
        for (String line : arr) {
            message.append(line).append("#");
        }

        System.out.printf("Расшифрованное послание: %s", message);

//    2 Условия&Циклы: «Ночная смена в QA-департаменте»

        String[] autotests = new String[100 + 1];

        int countPass = 0;
        int countCritical = 0;
        int countBug = 0;
        int countFlaky = 0;

        boolean showOnlyIssues = true;
        boolean stopSignal = false;

        for (int i = 0; i < autotests.length; i++) {
            if (i == 0) {
                autotests[i] = "Health check";
            } else if (i % 3 == 0 && i % 5 == 0) {
                if(countCritical >= 3) {
                    System.out.println("\uD83D\uDEA8 Слишком много критических багов — будим тимлида!");
                    stopSignal = true;
                    break;
                }
                else {
                    autotests[i] = "Critical!";
                    System.out.printf("Тест #%d: %s", i, autotests[i] + "\n");
                    countCritical++;
                }
            } else if (i % 5 == 0) {
                autotests[i] = "Bug";
                System.out.printf("Тест #%d: %s", i, autotests[i] + "\n");
                countBug++;
            } else if (i % 3 == 0) {
                autotests[i] = "Flaky";
                System.out.printf("Тест #%d: %s", i, autotests[i] + "\n");
                countFlaky++;
            } else {
                autotests[i] = "Pass";
                countPass++;
                if(showOnlyIssues && autotests[i].equals("Pass")) {
                    continue;
                }
                else System.out.printf("Тест #%d: %s", i, autotests[i] + "\n");
            }
        }

        if(!stopSignal) {
            System.out.println("\n" +
                    "===== ИТОГИ НОЧНОЙ СМЕНЫ =====" + "\n" +
                    "Всего тестов: " + (autotests.length - 1) + "\n" +
                    "Pass: " + countPass + "\n" +
                    "Flaky: " + countFlaky + "\n" +
                    "Bug: " + countBug + "\n" +
                    "Critical: " + countCritical);
        }
    }
}
