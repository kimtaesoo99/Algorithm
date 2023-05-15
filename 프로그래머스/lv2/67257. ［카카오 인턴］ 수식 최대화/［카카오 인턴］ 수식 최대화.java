import java.util.ArrayList;
import java.util.List;

class Solution {
    static long answer = 0;
    static String expression;
    static List<Long> numbers;
    static List<Character> operation;

    public long solution(String expression) {
        this.expression = expression;
        divisionExpression();
        permutation(0, 3, new char[]{'+', '-', '*'}, new boolean[3], "");
        return answer;
    }

    private void divisionExpression() {
        StringBuilder number = new StringBuilder();
        numbers = new ArrayList<>();
        operation = new ArrayList<>();
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
        List<Long> nowNumbers = new ArrayList<>(numbers);
        List<Character> nowOperation = new ArrayList<>(operation);
        for (int i = 0; i < operator.length(); i++) {
            char now = operator.charAt(i);
            int index;
            while (nowOperation.size() != 0) {
                index = nowOperation.indexOf(now);
                if (index == -1) {
                    break;
                }
                switch (now) {
                    case '+':
                        nowNumbers.add(index, nowNumbers.get(index) + nowNumbers.get(index + 1));
                        break;
                    case '-':
                        nowNumbers.add(index, nowNumbers.get(index) - nowNumbers.get(index + 1));
                        break;
                    case '*':
                        nowNumbers.add(index, nowNumbers.get(index) * nowNumbers.get(index + 1));
                        break;
                }
                nowNumbers.remove(index + 1);
                nowNumbers.remove(index + 1);
                nowOperation.remove(index);
            }
        }
        answer = Math.max(answer, Math.abs(nowNumbers.get(0)));
    }
}