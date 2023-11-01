import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static List<String> vowels = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String password = sc.nextLine();
            if (password.equals("end")) {
                break;
            }

            if (checkPassword(password)) {
                sb.append("<").append(password).append(">").append(" is acceptable.\n");
                continue;
            }
            sb.append("<").append(password).append(">").append(" is not acceptable.\n");
        }
        System.out.println(sb);
    }

    private static boolean checkPassword(String password) {
        if (!hasVowel(password)) {
            return false;
        }
        if (isSameTypeThreeTimes(password)) {
            return false;
        }
        return !isSameCharTwoTimes(password);
    }

    private static boolean hasVowel(String password) {
        return Arrays.stream(password.split(""))
                .anyMatch(p -> vowels.contains(p));
    }

    private static boolean isSameTypeThreeTimes(String password) {
        int count = 0;
        String first = password.split("")[0];
        boolean nowVowel = vowels.contains(first);
        for (String p : password.split("")) {
            if (vowels.contains(p)) {
                if (nowVowel) {
                    count++;
                } else {
                    count = 1;
                    nowVowel = true;
                }
            } else {
                if (nowVowel) {
                    count = 1;
                    nowVowel = false;
                } else {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameCharTwoTimes(String password) {
        Stack<String> stack = new Stack<>();
        for (String p : password.split("")) {
            if (p.equals("e") || p.equals("o")) {
                continue;
            }
            if (!stack.isEmpty() && stack.peek().equals(p)) {
                return true;
            }
            stack.push(p);
        }
        return false;
    }
}
