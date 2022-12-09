import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(List.of(s1));
        return (int)Arrays.stream(s2).filter(set::contains).count();
    }
}