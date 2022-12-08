


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(this::isVowel).collect(Collectors.joining());
    }

    private boolean isVowel(String alpha){
        List<String> vowel = List.of("a","u","o","i","e");
        if (vowel.contains(alpha))return false;
        return true;
    }
}
