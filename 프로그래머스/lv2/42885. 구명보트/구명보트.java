
import java.util.Arrays;
class Solution {
public static int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int last = people.length-1;
        for (int i=0;i<people.length/2;i++){
            if (last<i)break;
            if (people[i]+people[last]>limit){
                count++;
                last--;
                i--;
            }
            else {
                count++;
                last--;
            }
        }

        return count;
    }
}