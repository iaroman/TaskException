public class Main {
    public static void main(String[] args) {
        AuthenticationValidator newUser = new AuthenticationValidator(
                        "Roman_123",
                        "Qwerty123",
                        "Qwerty123");
        newUser.checkDataUser();
    }
}