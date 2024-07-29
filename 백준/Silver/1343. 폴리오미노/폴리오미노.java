import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String[] result = str.split("\\.");

        boolean can = true;

        for (String s : result) {
            if (s.length() % 2 == 1) {
                can = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        String result2 = "";

        if (can) {
            for (String s : result) {
                int length = s.length();

                int division = length / 4;
                int remain = length % 4;

                for (int i = 0; i < division; i++) {
                    sb.append("AAAA");
                }

                for (int j = 0; j < remain; j++) {
                    sb.append("B");
                }
                sb.append(".");
            }
            if (sb.length() > 0) {
                result2 = sb.substring(0, sb.length() - 1);
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '.') {
                result2 += ".";
            } else {
                break;
            }
        }

        if (can) {
            System.out.println(result2);
        } else {
            System.out.println(-1);
        }
    }
}