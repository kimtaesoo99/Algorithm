
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> solution(String[] quiz) {
        List<String> answer = new ArrayList<>();
        for (String q : quiz) {
            List<String> list = Arrays.stream(q.split(" ")).collect(Collectors.toList());
            if (checkCorrect(list))answer.add("O");
            else answer.add("X");
        }
        return answer;
    }

    private boolean checkCorrect(List<String> list) {
        int result = 0;
        if (list.get(1).equals("+")) {
            result += Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(2));
        }
        if (list.get(1).equals("-")) {
            result += Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(2));
        }
        return (result == Integer.parseInt(list.get(4)));
    }
}
