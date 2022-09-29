public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] check = new int[10];
        for (int i=0;i<numbers.length; i++){
            check[numbers[i]]++;
        }
        for (int i=0;i<10; i++){
            if (check[i]==0)answer=answer+i;
        }

        return answer;
    }
}