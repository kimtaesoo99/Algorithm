import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        int[] answer = {0, 0};

        for (String operation : operations) {
            String condition = operation.split(" ")[0];
            Integer value = Integer.parseInt(operation.split(" ")[1]);
            if (condition.equals("I")){
                minQ.add(value);
                maxQ.add(value);
                continue;
            }
            if (maxQ.isEmpty()||minQ.isEmpty())continue;
            if (value==1){
                int delete = maxQ.poll();
                minQ.remove(delete);
            }else {
                int delete = minQ.poll();
                maxQ.remove(delete);
            }
        }
        if (!maxQ.isEmpty()){
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}