import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String my_string) {
          List<Integer> cost = Arrays.stream(my_string.split(" "))
                .filter(i -> i.matches("[0-9]+"))
                .map(i -> Integer.parseInt(i))
                .collect(Collectors.toList());

        List<String> operator = Arrays.stream(my_string.split(" "))
                .filter(i -> i.equals("+") || i.equals("-"))
                .collect(Collectors.toList());
        
        int sum = cost.get(0);
        int count = 1;
        for (String next : operator){
            int nextInt = cost.get(count++);
            if (next.equals("-")){
                nextInt = (-1)*nextInt;
            }
            sum +=nextInt;
        }

        return sum;
    }
}