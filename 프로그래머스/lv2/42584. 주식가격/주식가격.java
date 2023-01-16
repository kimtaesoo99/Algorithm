import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length; i++){
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.peek()] = prices.length - stack.peek() -1;
            stack.pop();
        }
        return result;
    }
}