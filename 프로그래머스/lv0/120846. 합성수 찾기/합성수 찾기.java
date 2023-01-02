import java.util.stream.IntStream;

class Solution {
    public long solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> IntStream.rangeClosed(1,i)
                        .filter(i2 ->i%i2==0).count()>2).count();
    }
}