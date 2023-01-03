
import java.util.List;

class Solution {
    List<String> phone = List.of("123","456","789","0");
    public String solution(int[] numbers, String hand) {
        int left = -1;
        int right = -1;
        StringBuilder sb = new StringBuilder();
        for (int n : numbers){
            if (n==1 || n ==4 || n== 7){
                sb.append("L");
                left = n;
                continue;
            } else if (n == 3 || n ==6 || n==9){
                sb.append("R");
                right = n;
                continue;
            }
            int leftDistance = distance(left,n);
            int rightDistance = distance(right,n);
            System.out.println(
                    "left = " +left + " right = " + right + " end = " + n+"\n"+
                    leftDistance + " " + rightDistance);
            if (leftDistance<rightDistance){
                left = n;
                sb.append("L");
                continue;
            } else if (leftDistance>rightDistance) {
                right = n;
                sb.append("R");
                continue;
            }
            if (hand.equals("left")){
                left = n;
                sb.append("L");
                continue;
            }
            right = n;
            sb.append("R");
        }
        return sb.toString();
    }

    int distance(int start , int end){
        int count = Math.abs((getIndex(start)) - (getIndex(end)));
        if ("2580".contains(String.valueOf(start))) count -= 1;
        return count;
    }

    int getIndex(int number){
        int count = 0;
        if (number == -1)return 4;
        for (int i = 0; i< phone.size(); i++){
            if (phone.get(i).contains(String.valueOf(number)))count = i+1;
        }
        return count;
    }
}