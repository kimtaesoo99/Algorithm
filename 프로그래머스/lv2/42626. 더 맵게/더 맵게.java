import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        while (queue.size()<2||queue.peek()<=K){
            Integer a = queue.poll();
            Integer b = queue.poll();
            if (a==null)return -1;
            if (a>=K)return answer;
            if (b==null)return -1;
            queue.offer(a+b*2);
            answer++;
        }
        return answer;
    }
}