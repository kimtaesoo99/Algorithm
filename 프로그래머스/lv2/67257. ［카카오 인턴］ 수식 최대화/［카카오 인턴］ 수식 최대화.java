import java.util.ArrayList;
import java.util.List;

class Solution {
    static long answer = 0;
    static String expression;

    public long solution(String expression) {
        this.expression = expression;
        permutation(0, 3, new char[]{'+', '-', '*'}, new boolean[3], "");
        return answer;
    }

    private void permutation(int index, int target, char[] operation, boolean[] check, String result) {
        if (index == target) {
            calc(result);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                permutation(index + 1, target, operation, check, result + operation[i]);
                check[i] = false;
            }
        }
    }

    private void calc(String operator) {
        StringBuilder number = new StringBuilder();
        List<Long> numbers = new ArrayList<>();
        List<Character> operation = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                numbers.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                operation.add(expression.charAt(i));
                continue;
            }
            number.append(expression.charAt(i));
        }
        numbers.add(Long.parseLong(number.toString()));

        for (int i = 0; i < operator.length(); i++) {
            char now = operator.charAt(i);
            int index;
            while (operation.size() != 0) {
                index = operation.indexOf(now);
                if (index == -1) {
                    break;
                }
                switch (now) {
                    case '+':
                        numbers.add(index, numbers.get(index) + numbers.get(index + 1));
                        break;
                    case '-':
                        numbers.add(index, numbers.get(index) - numbers.get(index + 1));
                        break;
                    case '*':
                        numbers.add(index, numbers.get(index) * numbers.get(index + 1));
                        break;
                }
                numbers.remove(index + 1);
                numbers.remove(index + 1);
                operation.remove(index);
            }
        }
        answer = Math.max(answer, Math.abs(numbers.get(0)));
    }
}
