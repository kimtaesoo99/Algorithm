import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static boolean[] prime;
    static Map<Integer, Integer> distance;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        findPrime();

        for (int i = 0; i < T; i++){
            int origin = sc.nextInt();
            int conversion = sc.nextInt();
            distance = new HashMap<>();
            findDistance(origin);
            sb.append(distance.get(conversion)).append("\n");
        }
        System.out.println(sb);
    }

    private static void findPrime(){
        prime = new boolean[10000];
        Arrays.fill(prime,true);
        for (int i = 2; i < 5000; i++){
            for (int j = 2; j*i <10000; j++){
                prime[i*j] = false;
            }
        }
    }

    private static void findDistance(int origin){
        Queue<Integer> q = new LinkedList<>();
        q.offer(origin);
        distance.put(origin,0);

        while (!q.isEmpty()){
            int now = q.poll();

            for (int i = 1000; i <= 9999; i++){
                if (canConvert(i,now)){
                    if (!distance.containsKey(i)){
                        distance.put(i, distance.get(now)+1);
                        q.offer(i);
                    }
                }
            }
        }
    }

    private static boolean canConvert(int num,int now){
        if (!prime[num])return false;
        int count = 0;
        String origin = String.valueOf(num);
        String conversion = String.valueOf(now);
        for (int i = 0; i < 4; i++){
            if (origin.charAt(i)!=conversion.charAt(i))count++;
        }
        return count==1;
    }

}
