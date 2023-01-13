
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> solution(String[] record) {
        Map<String, String> idAndNickname = new HashMap<>();
        for (String s : record) {
            String[] info = s.split(" ");
            if (info[0].equals("Leave"))continue;
            idAndNickname.put(info[1],info[2]);
        }
        List<String> result = new LinkedList<>();
        for (String s : record) {
            String[] info = s.split(" ");
            if (info[0].equals("Enter")){
                result.add(idAndNickname.get(info[1]) + "님이 들어왔습니다.");
            } else if (info[0].equals("Leave")) {
                result.add(idAndNickname.get(info[1]) + "님이 나갔습니다.");
            }
        }

        return result;
    }
}