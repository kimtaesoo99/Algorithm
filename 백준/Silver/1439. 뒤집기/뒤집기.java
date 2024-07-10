import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.peek() != c) {
                stack.push(c);
            }
        }

        int zero = 0;
        int one = 0;

        while (!stack.isEmpty()) {
            Character now = stack.pop();
            if (now == '0') {
                zero++;
            } else {
                one++;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
