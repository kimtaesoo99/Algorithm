
import java.util.List;

class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        List<String> canSpeakWords = List.of("aya", "ye", "woo", "ma");
        List<String> canNotSpeakWords = List.of("ayaaya", "yeye", "woowoo", "mama");
        for (String speak : babbling) {
            for (String word : canNotSpeakWords){
                if (speak.contains(word))speak = "0";
            }
            for (String word : canSpeakWords) {
                speak = speak.replace(word, ",");
            }
            speak = speak.replace(",", "");
            if (speak.equals("")) {
                count++;
            }
        }
        return count;
    }
}