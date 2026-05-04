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

        System.out.printf("Расшифрованное послание: %s", String.join("#", arr));

//    2 Условия&Циклы: «Ночная смена в QA-департаменте»

        int countPass = 0;
        int countCritical = 0;
        int countBug = 0;
        int countFlaky = 0;

        boolean showOnlyIssues = false;
        boolean stopSignal = false;

        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                if(countCritical >= 2) {
                    System.out.println("\uD83D\uDEA8 Слишком много критических багов — будим тимлида!");
                    stopSignal = true;
                    break;
                }
                else {
                    System.out.printf("Тест #%d: %s", i, "Critical!" + "\n");
                    countCritical++;
                }
            } else if (i % 5 == 0) {
                System.out.printf("Тест #%d: %s", i, "Bug" + "\n");
                countBug++;
            } else if (i % 3 == 0) {
                System.out.printf("Тест #%d: %s", i, "Flaky" + "\n");
                countFlaky++;
            } else {
                countPass++;
                if(showOnlyIssues) {
                    System.out.printf("Тест #%d: %s", i, "Pass" + "\n");
                }
            }
        }

        int totalTest = countPass + countCritical + countBug + countFlaky;

        if(!stopSignal) {
            System.out.println("\n" +
                    "===== ИТОГИ НОЧНОЙ СМЕНЫ =====" + "\n" +
                    "Всего тестов: " + totalTest + "\n" +
                    "Pass: " + countPass + "\n" +
                    "Flaky: " + countFlaky + "\n" +
                    "Bug: " + countBug + "\n" +
                    "Critical: " + countCritical);
        }
    }
}
