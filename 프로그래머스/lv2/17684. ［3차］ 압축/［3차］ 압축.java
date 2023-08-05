import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    static HashMap<String, Integer> dictionary;
    static List<Integer> result;
    static int lastIndex;

    public List<Integer> solution(String msg) {
        init();
        findWord(msg);
        return result;
    }

    private void init() {
        dictionary = new HashMap<>();
        result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        lastIndex = 27;
    }

    private void findWord(String msg) {
        int pre = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char now = msg.charAt(i);
            word.append(now);
            if (!dictionary.containsKey(word.toString())) {
                result.add(pre);
                dictionary.put(word.toString(), lastIndex++);
                word.setLength(0);
                i--;
                continue;
            }
            pre = dictionary.get(word.toString());
        }
        result.add(pre);
    }
}