import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int index = 0;
        for (int i = 1; i < order.length + 1; i++) {
            if (order[index] == i) {
                answer++;
                index++;
            } else {
                s.add(i);
            }
            while (!s.isEmpty() && s.peek() == order[index]) {
                s.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}