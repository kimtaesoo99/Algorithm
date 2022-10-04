

public class Solution {
    public int[] solution(int [] n) {
        int count =0;
        for (int i=1;i<n.length;i++){
            if (n[i-1]!=n[i])count++;
        }
        int[] answer = new int[count+1];
        answer[0] = n[0];
        int k=1;
        for (int i =1;i<n.length;i++){
            if (n[i-1]!=n[i])answer[k++]=n[i];
        }


        return answer;
    }
}