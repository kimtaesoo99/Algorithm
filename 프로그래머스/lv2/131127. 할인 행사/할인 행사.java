import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i],number[i]);
        }

        int day = 0;
        for(int i = 0; i < discount.length; i++){
            if(wantBuy(map, discount[i])){
                map.put(discount[i],map.get(discount[i])-1);
            }
            if(i>=10){
                if(wantBuy(map, discount[i-10])){
                    map.put(discount[i-10],map.get(discount[i-10])+1);
                }
            }
            if(canBuy(map)){
                day++;
            }
        }
        return day;
    }

    public boolean canBuy(Map<String,Integer> map){
        return map.values().stream().allMatch(i-> i == 0);
    }

    public boolean wantBuy(Map<String,Integer> map , String a){
        return map.containsKey(a);
    }
}
