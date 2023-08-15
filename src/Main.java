public class Main {
    public static void main(String[] args) {
        enterDataUser("Roman_123", "Qwerty123", "Qwerty123");
    }
    public static void enterDataUser(String login, String password, String confirmPassword) {
        try {
            checkChars(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
        String loginUser = new String(login);
        String passwordUser = new String(password);
        String confirmPasswordUser = new String(confirmPassword);
    }
    public static void checkChars(String loginForCheck, String passwordForCheck, String confirmPasswordForCheck)
            throws WrongLoginException, WrongPasswordException {

        char[] correctChars = new char[63];
        int i = 0;
        for (; i < 10; i++) {
            correctChars[i] = (char) ('0' + i);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            correctChars[i] = c;
            i++;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            correctChars[i] = c;
            i++;
        }
        correctChars[i] = '_';
        String stringCorrectChars = new String(correctChars);

        char[] charsForCheck = loginForCheck.toCharArray();
        for (int j = 0; j < charsForCheck.length; j++) {
            if (stringCorrectChars.indexOf(charsForCheck[j]) == -1)
                throw new WrongLoginException("Логин не соотвествует требованиям");
        }

        if (loginForCheck.length() > 20)
            throw new WrongLoginException("Логин слишком длинный");

        char[] charsPwForCheck = passwordForCheck.toCharArray();
        for (int j = 0; j < charsPwForCheck.length; j++) {
            if (stringCorrectChars.indexOf(charsPwForCheck[j]) == -1)
                throw new WrongPasswordException("Пароль не соотвествует требованиям");
        }

        if (passwordForCheck.length() > 20)
            throw new WrongPasswordException("Пароль слишком длинный");

        if (!passwordForCheck.equals(confirmPasswordForCheck))
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
    }
}