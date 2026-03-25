import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LinkExtractor {

    public static void main(String[] args) {
        String html = "<a href=\"https://google.com\">Google</a> "
                + "<a href=\"https://github.com\">GitHub</a>";

        String regex = "<a\\s+[^>]*href=\"([^\"]*)\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}