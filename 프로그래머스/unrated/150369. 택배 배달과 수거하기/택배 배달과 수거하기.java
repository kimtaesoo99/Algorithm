import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int sizeOfLastDeliveries = 0;
        int sizeOfLastPickups = 0;

        List<Integer> reverseDeliveries = new ArrayList<>();
        List<Integer> reversePickups = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            reverseDeliveries.add(deliveries[i]);
            reversePickups.add(pickups[i]);
        }

        for (int i = 0; i < n; i++) {
            sizeOfLastDeliveries -= reverseDeliveries.get(i);
            sizeOfLastPickups -= reversePickups.get(i);

            while (true) {
                if(sizeOfLastDeliveries >= 0 && sizeOfLastPickups >= 0) {
                    break;
                }
                sizeOfLastDeliveries += cap;
                sizeOfLastPickups += cap;
                answer += (n - i) * 2L;
            }
        }
        return answer;
    }
}