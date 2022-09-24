
public class Solution {
    public int solution(long num) {

        int count=0;
        for (int i=0; i<501; i++){
            if (num==1)break;
            if (num%2==0)num/=2;
            else num=num*3+1;
            count++;
            if (i==500)return -1;
        }

         return count;

    }
}