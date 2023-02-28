
import java.util.ArrayList;
import java.util.List;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        for (int i = n-1; i>=0; i--){
            if (deliveries[i]!=0 || pickups[i]!=0){
                answer+=2*(i+1);
                break;
            }
        }

        List<Integer> deliveriesIndex = new ArrayList<>();
        int count = cap;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i]==0)continue;

            int remove = count - deliveries[i];
            if (remove > 0) {
                count -= deliveries[i];
            } else if (remove == 0) {
                count = 0;
            } else {
                deliveries[i] -= count;
                count = cap;
                deliveriesIndex.add(i);
                i++;
            }
        }

        List<Integer> pickupsIndex = new ArrayList<>();
        int count2 = cap;
        for (int i = n - 1; i >= 0; i--) {

            int remove = count2 - pickups[i];
            if (remove > 0) {
                count2 -= pickups[i];
            } else if (remove == 0) {
                count2 =0;
            } else {
                pickups[i] -= count2;
                count2 = cap;
                pickupsIndex.add(i);
                i++;
            }
        }
        int sameSize = Math.min(deliveriesIndex.size(), pickupsIndex.size());
        for (int i = 0; i < sameSize; i++){
            answer+= 2L * (Math.max(deliveriesIndex.get(i)+1,pickupsIndex.get(i)+1));
        }
        if (deliveriesIndex.size() > pickupsIndex.size()){
            for (int i = sameSize; i <deliveriesIndex.size(); i++)answer += 2L * (deliveriesIndex.get(i)+1);
        }else
            for (int i = sameSize; i <pickupsIndex.size(); i++)answer += 2L * (pickupsIndex.get(i)+1);

        return answer;
    }
}