import java.util.*;

class Solution {
    static Map<String,String> carAndInTime;
    static Map<String,Integer> carAndFee;
    public int[] solution(int[] fees, String[] records) {
        carAndInTime = new HashMap<>();
        carAndFee = new HashMap<>();

        for(String s : records){
            String[] info = s.split(" ");
            String time = info[0];
            String carNumber = info[1];
            String type = info[2];
            if(type.equals("IN")){
                carAndInTime.put(carNumber,time);
            }else {
                carAndFee.put(carNumber, carAndFee.getOrDefault(carNumber,0) + getTime(time,carNumber));
                carAndInTime.remove(carNumber);
            }
        }
        Set<String> set = carAndInTime.keySet();
        for(String carNumber : set){
            carAndFee.put(carNumber, carAndFee.getOrDefault(carNumber,0) + getTime("23:59",carNumber));
        }
        return carAndFee.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(i -> getFee((carAndFee.get(i.getKey())),fees)).mapToInt(Integer::intValue)
                .toArray();
    }

    public int getTime(String time, String carNumber){
        String[] inTime = carAndInTime.get(carNumber).split(":");
        int inTimeHour = Integer.parseInt(inTime[0]);
        int inMin = Integer.parseInt(inTime[1]);

        String[] outTime = time.split(":");
        int outTimeHour = Integer.parseInt(outTime[0]);
        int outMin = Integer.parseInt(outTime[1]);

        int totalTime = (outTimeHour - inTimeHour)*60 +outMin - inMin;
        return totalTime;
    }

    public int getFee(int time, int[] fees){
        int basicTime = fees[0];
        int basicFee = fees[1];
        int overTime = fees[2];
        int overFee = fees[3];
        if(time<=basicTime)return basicFee;
        else{
            int over = time - basicTime;
            return (int)Math.ceil(over/(double)overTime)*overFee + basicFee;
        }
    }
}
