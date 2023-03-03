import java.util.*;
class Solution {
    static Map<String,List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(String i : info){
            String[] arr = i.split(" ");
            comb(arr,0,"");
        }

        for(String k : map.keySet())Collections.sort(map.get(k));


        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++){
            String[] q = query[i].replace(" and ","").split(" ");
            int index = 0;
            if(map.containsKey(q[0]))index =binary(map.get(q[0]),Integer.parseInt(q[1]));
            answer[i] = index;
        }
        return answer;
    }

    public int binary(List<Integer> list, int value){
        int start = 0;
        int end = list.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < value)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return list.size() - start;
    }

    public void comb(String[] info, int index, String result){
        if(index == 4){
            if(!map.containsKey(result)){
                List<Integer> list = new ArrayList<>();
                map.put(result,list);
            }
            map.get(result).add(Integer.parseInt(info[4]));
            return;
        }

        comb(info,index+1, result+"-");
        comb(info,index+1,result+info[index]);
    }
}
