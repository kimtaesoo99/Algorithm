import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = move(s[i]);
        }
        return answer;
    }

    private String move(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= 3) {
                char first = stack.pop();
                if (first != '0') {
                    stack.push(first);
                    continue;
                }
                char second = stack.pop();
                if (second != '1') {
                    stack.push(second);
                    stack.push(first);
                    continue;
                }
                char third = stack.pop();
                if (third != '1') {
                    stack.push(third);
                    stack.push(second);
                    stack.push(first);
                    continue;
                }
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int zeroIndex = -1;
        int size = stack.size() - 1;
        while (!stack.isEmpty()) {
            char now = stack.pop();
            sb.insert(0, now);
            if (zeroIndex == -1 && now == '0') {
                zeroIndex = size;
            }
            size--;
        }
        int index = (zeroIndex == -1 ? 0 : ++zeroIndex);
        sb.insert(index, "110".repeat(count));
        return sb.toString();
    }
}