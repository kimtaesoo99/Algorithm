import java.util.List;

class Solution {
    static int[] value = {1, -1, 10, -10};
    static List<Character> name = List.of('w','s','d','a');
    
    public int solution(int n, String control) {
        for (int i = 0; i < control.length(); i++) {
            n += value[name.indexOf(control.charAt(i))];
        }
        return n;
    }
}