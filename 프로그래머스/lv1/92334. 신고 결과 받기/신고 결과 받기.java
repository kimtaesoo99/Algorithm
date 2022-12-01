
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


class Solution {
    static Map<String, Set<String>> reportList = new HashMap<>();
    static Map<String,Integer> reportedCount = new HashMap<>();
    static List<String> stopUser = new ArrayList<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저가 신고한 사람 목록 만들기
        for (String str : report){
            Object[] arr = Arrays.stream(str.split(" "))
                    .toArray();
            Set<String> reportedList = reportList.getOrDefault(arr[0],new HashSet<>());
            reportedList.add((String) arr[1]);
            reportList.put((String) arr[0],reportedList);
        }
        //각 유저의 신고 받은 횟수 저장
        getReportName();
        //정지를 해야할 유저들을 리스트에 저장
        getStopUser(k);
        //정지 유저를 포함한 횟수만큼 이메일을 보냄
        return getEmailCount(id_list);
    }

    static void getReportName(){
        for (Set<String> name : reportList.values()){
            for (String s : name){
                reportedCount.put(s,reportedCount.getOrDefault(s,0)+1);
            }
        }
    }

    static void getStopUser(int k){
        for (Entry<String, Integer> e : reportedCount.entrySet()){
            if (e.getValue()>=k)stopUser.add(e.getKey());
        }
    }

    static int[] getEmailCount(String[] id_list){
        int[] emailCount = new int[id_list.length];
        int index = 0;
        for (String s : id_list){
            for (String name : reportList.getOrDefault(s,new HashSet<>())){
                if (stopUser.contains(name))emailCount[index]++;
            }
            index++;
        }
        return emailCount;
    }
}
