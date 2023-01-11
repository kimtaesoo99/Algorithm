import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String cipher, int code) {
        return IntStream.rangeClosed(0,cipher.length()-1)
                .filter(i -> (i+1)%code ==0).mapToObj(n -> String.valueOf(cipher.charAt(n))).collect(Collectors.joining());
    }
}