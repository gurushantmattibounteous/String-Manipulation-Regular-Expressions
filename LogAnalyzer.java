import java.util.*;
import java.util.regex.*;

public class LogAnalyzer {

    public static void main(String[] args) {

        String[] logs = {
                "[2023-10-27 14:32:01] [ERROR] User login failed for IP: 192.168.0.155 - Timeout",
                "[2023-10-27 14:35:10] [INFO] User login success for IP: 192.168.0.100",
                "[2023-10-27 14:40:55] [ERROR] Payment failed for IP: 10.0.0.1",
                "[2023-10-27 14:42:00] [WARN] Disk almost full for IP: 172.16.0.5",
                "[2023-10-27 14:50:00] [ERROR] Timeout for IP: 192.168.0.155"
        };

        // Regex with capture groups
        String regex = "\\[(.*?)\\] \\[(.*?)\\].*IP: ([\\d\\.]+)";
        Pattern pattern = Pattern.compile(regex);

        int errorCount = 0;
        Set<String> uniqueIPs = new HashSet<>();

        for (String log : logs) {
            Matcher matcher = pattern.matcher(log);

            if (matcher.find()) {
                String dateTime = matcher.group(1);
                String level = matcher.group(2);
                String ip = matcher.group(3);

                if (level.equals("ERROR")) {
                    errorCount++;
                    uniqueIPs.add(ip);
                }
            }
        }

        // Output
        System.out.println("Total ERROR logs: " + errorCount);
        System.out.println("Unique IPs causing ERROR:");
        for (String ip : uniqueIPs) {
            System.out.println(ip);
        }
    }
}