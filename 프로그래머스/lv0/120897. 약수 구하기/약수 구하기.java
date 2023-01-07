import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;


class Solution {
    public Set<Integer> solution(int n) {
        Set<Integer> set = new TreeSet<>();
        IntStream.rangeClosed(1,(int)Math.sqrt(n)).filter(i -> n%i==0).forEach(i -> {set.add(i);set.add(n/i);});
        return set;
    }
}