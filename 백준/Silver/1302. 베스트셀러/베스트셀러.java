import java.util.*;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<String> keyList = new ArrayList<>();
            int N = sc.nextInt();
            HashMap<String ,Integer> map =new HashMap<>();
            for (int i=0;i<N; i++){
                String name = sc.next();
                if (!map.containsKey(name)) {
                    map.put(name,1);
                }
                else map.put(name,map.get(name)+1);
            }

            int max = 0;
            for(String a : map.keySet()){
                max = Math.max(max, map.get(a));
          }
         for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue().equals(max)){
                keyList.add(entry.getKey());
            }
         }
         Collections.sort(keyList);
         System.out.println(keyList.get(0));
    }
}
