public class Main {
    public static void method(String login, String password, String confirmPassword){

    }

    public static void main(String[] args) {
        char [] loginChars = new char [63];
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            loginChars[i] = c;

            System.out.println(loginChars[i]);

            i++;
        }
    }
}