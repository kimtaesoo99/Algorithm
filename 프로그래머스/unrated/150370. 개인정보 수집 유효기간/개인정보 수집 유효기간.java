import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (String term : terms) {
            String[] termInfo = term.split(" ");
            map.put(termInfo[0], Integer.parseInt(termInfo[1]));
        }

        System.out.println(map);

        int index = 1;
        for (String privacy : privacies) {
            String[] date = privacy.split("\\.| ");
            if (isOverDate(today,date,map))result.add(index);
            index++;
        }

        return result;
    }

    boolean isOverDate(String today, String[] date, Map<String,Integer> map){
        String[] todayInfo = today.split("\\.");
        int validity = map.get(date[3]);
        int year = Integer.parseInt(todayInfo[0]) - Integer.parseInt(date[0]);

        int month = (Integer.parseInt(todayInfo[1])+year*12) - Integer.parseInt(date[1]);

        int day = (Integer.parseInt(todayInfo[2])+month*28) - Integer.parseInt(date[2]);

        int result = day - (validity*28);
        if (result>=0)return true;
        return false;
    }
}