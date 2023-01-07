import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String,Integer> map = new HashMap<>();
        String[] mbti = {"R","T","C","F","J","M","A","N"};
        for (int number =0; number<choices.length; number++) {
            String first = survey[number].split("")[0];
            String second = survey[number].split("")[1];
            switch (choices[number]){
                case 1:
                    map.put(first,map.getOrDefault(first,0)+3);
                    break;
                case 2:
                    map.put(first,map.getOrDefault(first,0)+2);
                    break;
                case 3:
                    map.put(first,map.getOrDefault(first,0)+1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(second,map.getOrDefault(second,0)+1);
                    break;
                case 6:
                    map.put(second,map.getOrDefault(second,0)+2);
                    break;
                case 7:
                    map.put(second,map.getOrDefault(second,0)+3);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<4;i++){
            int first = map.getOrDefault(mbti[2*i],0);
            int second = map.getOrDefault(mbti[2*i+1],0);
            String result = first>=second?mbti[2*i]:mbti[2*i+1];
            sb.append(result);
        }
        return sb.toString();
    }
}