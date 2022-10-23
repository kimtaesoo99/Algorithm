
public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.toLowerCase().split("");

        boolean flag = true;
        for (int i=0;i<arr.length;i++){
            sb.append(flag?arr[i].toUpperCase():arr[i]);
            flag = arr[i].equals(" ")? true: false;
        }

        return sb.toString();
    }
}