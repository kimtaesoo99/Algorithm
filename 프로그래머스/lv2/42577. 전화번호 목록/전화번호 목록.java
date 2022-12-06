

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = Arrays.stream(phone_book).collect(Collectors.toList());
        Collections.sort(list);
     

        for (int i = 0; i < list.size()-1; i++) {
           if (list.get(i+1).startsWith(list.get(i))){
               answer = false;
               break;
           }
        }

        return answer;
    }
}
