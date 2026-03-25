import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {

    public static void main(String[] args) {
        String password = "Abc@1234";

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%&]).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }
}