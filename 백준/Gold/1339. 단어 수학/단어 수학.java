import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main{
    static int sum = 0;
    static int value = 9;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            String str = sc.next();
            int index = 0;
            for (int j = str.length()-1; j>=0; j--){
                map.put(str.charAt(index), (int) (map.getOrDefault(str.charAt(index),0)+Math.pow(10,j)));
                index++;
            }
        }
        map.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(i -> {
                    sum+=i.getValue()*value;
                    value--;
                });
        System.out.println(sum);
    }
}
