import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        try {
            workingWithExceptions("ss3ljsl", "jjss", "jjsdds");
        } catch (WrongLoginException e) {
            System.out.println("Недопустимые символы в логине");
        } catch (WrongPasswordException e) {
            if (Objects.equals(e.getMessage(), "Недопустимые значения в пароле")) {
                System.out.println("Недопустимые символы в пароле");
            } else if (Objects.equals(e.getMessage(), "пароли не совпадают")) {
                System.out.println("пароли не совпадают");
            }
        } finally {
            System.out.println("Метод завершил свою работу");
        }
    }

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz_0123456789";

    public static void workingWithExceptions(String login, String password, String confirmPassword) {
        if (!checkingСorrectnessСharacters(login)) {
            throw new WrongLoginException();
        }


        if (!checkingСorrectnessСharacters(password)) {
            throw new WrongPasswordException("Недопустимые значения в пароле");
        }


        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }
    }


    public static boolean checkingСorrectnessСharacters(String string) {
        if (string.length() > 20) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (alphabet.indexOf(currentChar) == -1 && alphabet.indexOf(Character.toLowerCase(currentChar)) == -1) {
                return false;
            }
        }
        return true;
    }
}