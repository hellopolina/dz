import java.time.LocalDate;
import java.util.Random;

public class dz5 {

    public static void main(String[] args) {
        String accessCode = generateAccessCode();
        System.out.printf("Код доступа %s валидный? %s", accessCode, isValidCode(accessCode, 8) + "\n");
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        System.out.println(generateAgentId("AGENT", 42));
        System.out.println(generateAgentId("AGENT", 77));
        System.out.println(generateAgentId("AGENT", 13));
    }

    public static String generateAccessCode() {
        int part1 = LocalDate.now().getYear();
        String part2 = "-";
        int part3 = (int) Math.pow(3, 7);

        return part1 + part2 + part3;
    }

    private static boolean isValidCode(String code, int minLength) {
        if(code != null && code.length() >= minLength && code.contains("-")) {
            return true;
        }
        return false;
    }

    public static void logEvent(String message) {
        System.out.printf("[INFO] {%s}" + "\n", message);
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.printf("[CRITICAL] {%s}" + "\n", message);
        }
        else logEvent(message);
    }

    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);
        int value = Math.abs(random.nextInt(1000, 10000));
        return "{" + prefix + "}-{" + value + "}";
    }
}
