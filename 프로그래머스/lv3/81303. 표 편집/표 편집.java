import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove = new Stack<>();
        int size = n;

        for (String s : cmd) {
            char c = s.charAt(0);
            if (c == 'D') {
                k += Integer.parseInt(s.substring(2));
            }
            if (c == 'U') {
                k -= Integer.parseInt(s.substring(2));
            }
            if (c == 'C') {
                remove.add(k);
                size--;
                if (k == size) {
                    k--;
                }
            }
            if (c == 'Z') {
                if (remove.pop() <= k) {
                    k++;
                }
                size++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        result.append("O".repeat(size));
        while (!remove.isEmpty()) {
            result.insert(remove.pop(), "X");
        }
        return result.toString();
    }
}