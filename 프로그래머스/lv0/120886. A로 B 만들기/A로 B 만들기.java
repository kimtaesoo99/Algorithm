import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] a =  after.toCharArray();
        char[] b =  before.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b))?1 :0;
    }
}