package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "192.168.001.1"};

        String regex = "^(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9]{1,2})$";

        Pattern pattern = Pattern.compile(regex);

        for (String ip : ips) {
            if (pattern.matcher(ip).matches()) {
                System.out.println(ip + " is a valid IPv4 address.");
            } else {
                System.out.println(ip + " is NOT a valid IPv4 address.");
            }
        }
    }
}
