public class AuthenticationValidator {
    public AuthenticationValidator(String loginForCheck, String passwordForCheck, String confirmPasswordForCheck) {
        this.loginForCheck = loginForCheck;
        this.passwordForCheck = passwordForCheck;
        this.confirmPasswordForCheck = confirmPasswordForCheck;
    }
    private String loginForCheck;
    private String passwordForCheck;
    private String confirmPasswordForCheck;
    public void checkDataUser() {
        try {
            this.checkLogin();
            this.checkPassword();
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
    private String generateStringChars(){
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
        return stringCorrectChars;
    }
    private void checkLogin() throws WrongLoginException{
        String stringCorrectChars = generateStringChars();
        char[] charsForCheck = loginForCheck.toCharArray();
        for (int j = 0; j < charsForCheck.length; j++) {
            if (stringCorrectChars.indexOf(charsForCheck[j]) == -1)
                throw new WrongLoginException("Логин не соотвествует требованиям");
        }

        if (loginForCheck.length() > 20)
            throw new WrongLoginException("Логин слишком длинный");
    }
    private void checkPassword() throws WrongPasswordException{
        String stringCorrectChars = generateStringChars();
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
