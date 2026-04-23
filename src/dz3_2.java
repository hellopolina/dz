public class dz3_2 {

    public static void main(String[] args) {
        String[] passwords = {"123", "qwerty", "difficultPassword999!"};

        System.out.println(
                "пароль " + passwords[0] + " прошел проверку: " + checkPsw(passwords[0]) + "\n" +
                        "пароль " + passwords[1] + " прошел проверку: " + checkPsw(passwords[1]) + "\n" +
                        "пароль " + passwords[2] + " прошел проверку: " + checkPsw(passwords[2])
        );
    }

    public static boolean checkPsw(String password) {
        if (password.length() > 8 && !password.startsWith("1") && !password.endsWith("Z")
                && !password.contains("1234") && !password.contains("qwerty")) return true;
        else return false;
    }

}