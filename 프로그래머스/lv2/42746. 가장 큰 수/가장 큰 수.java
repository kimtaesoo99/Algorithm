import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        boolean onlyZero = true;
        String[] str = new String[numbers.length];
        for (int i = 0; i <str.length;i++){
            str[i] = String.valueOf(numbers[i]);
            if (numbers[i]!=0)onlyZero = false;
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++){
            sb.append(str[i]);
        }
        if (onlyZero) return "0";
        return sb.toString();
    }
}

class Play{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{6,10,2}));
    }
}
