public class Solution {
    public String solution(String[] arr) {
        int index=0;
        for (int i=0;i<arr.length; i++){
            if (arr[i].equals("Kim")){
                index = i;
                break;
            }
        }
       String answer = "김서방은 "+index +"에 있다";
        return answer;
    }
}