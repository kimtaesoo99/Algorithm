import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    static Map<String, Integer> orderCount;
    static int max;
    static List<String> results;
    public String[] solution(String[] orders, int[] course) {
        results = new ArrayList<>();
        for (int cutSize : course){
            max = 0;
            orderCount = new HashMap<>();
            for (String s : orders){
                comb(s,"",0, cutSize);
            }
            if (max<2)continue;
            orderCount.entrySet().stream().filter(e -> e.getValue() == max)
                    .forEach(e -> results.add(e.getKey()));
        }
        Collections.sort(results);
        return results.toArray(new String[0]);
    }

    public void comb(String word, String now, int index ,int cutSize){
        if (now.length() == cutSize){
            String sortedWord = sort(now);
            orderCount.put(sortedWord, orderCount.getOrDefault(sortedWord,0)+1);
            max = Math.max(max, orderCount.get(sortedWord));
            return;
        }

        for (int i = index; i < word.length(); i++){
            comb(word,now+word.charAt(i), i+1,cutSize);
        }
    }

    public String sort(String word){
        return Arrays.stream(word.split("")).sorted().collect(Collectors.joining());
    }
}