import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPv4Validator {

    public static void main(String[] args) {
        String ip = "192.168.1.1";

        String regex = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)"
                + "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            System.out.println("Valid IPv4");
        } else {
            System.out.println("Invalid IPv4");
        }
    }
}