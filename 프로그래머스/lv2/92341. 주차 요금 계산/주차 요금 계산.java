import java.util.*;
class Solution {
   
    static Map<String, String> map;
    static Map<String, Integer> feesMap;
    static Set<String> CarNUmber = new HashSet<>();

    static int[] cost;

    public static int[] solution(int[] fees, String[] records) {
        map = new HashMap<>();
        feesMap = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            if (records[i].endsWith("IN")) {
                map.put(records[i].substring(6, 10), records[i].substring(0, 5));
                CarNUmber.add(records[i].substring(6, 10));
            } else if (records[i].endsWith("OUT")) {
                getTime(records[i].substring(6, 10), records[i].substring(0, 5));
                map.remove(records[i].substring(6, 10));
            }
        }


        for (String key : map.keySet()) {
            // 이렇게 하면, map에 남아있는 키 값만 뽑아서 쓸 수 있음
            getTimeNotOut(key);
        }

        cost = new int[feesMap.size()];
        getCost(fees);

        return cost;
    }

    //시간을 저장하는 메서드
    public static void getTime(String CarNumber, String time) {
        int aHour = Integer.parseInt(time.substring(0, 2));
        int bHour = Integer.parseInt(map.get(CarNumber).substring(0, 2));
        int aMin = Integer.parseInt(time.substring(3, 5));  // 퇴장시간의 시간중 분단위
        int bMIn = Integer.parseInt(map.get(CarNumber).substring(3, 5));  //출입시간의 시간중 분단위

        feesMap.put(CarNumber, feesMap.getOrDefault(CarNumber, 0) + (aHour * 60 + aMin) - (bHour * 60 + bMIn));
    }

    public static void getTimeNotOut(String CarNumber) {
        int bHour = Integer.parseInt(map.get(CarNumber).substring(0, 2));
        int bMIn = Integer.parseInt(map.get(CarNumber).substring(3, 5));


        feesMap.put(CarNumber, feesMap.getOrDefault(CarNumber, 0) + (23 * 60 + 59) - (bHour * 60 + bMIn));
    }

    public static void getCost(int[] fees) {
        List<String> temp = new ArrayList<>();
        for (String num : CarNUmber) {
            temp.add((num));
        }
        Collections.sort(temp);

        int index = 0;
        for (int i = 0; i < temp.size(); i++) {
            int time = feesMap.get((temp.get(i)));
            if (time <= fees[0]) cost[index] = fees[1];
            else {
                cost[index] = (int) ((Math.ceil((time - fees[0]) / (double) fees[2]) * 1.0) * fees[3]) + fees[1];
            }
            index++;
        }
    }
}

