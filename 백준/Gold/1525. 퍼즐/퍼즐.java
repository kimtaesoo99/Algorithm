import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        for (int i = 0; i < 9; i++){
            int v = sc.nextInt();
            if (v==0)v = 9;
            value = (value*10) + v;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        map.put(value,0);
        q.offer(value);

        int[] dy = {1,0,-1,0};
        int[] dx = {0,-1,0,1};
        while (!q.isEmpty()){
            int nowNum = q.poll();
            String now = String.valueOf(nowNum);
            int nineIndex = now.indexOf("9");
            int y = nineIndex/3;
            int x = nineIndex%3;
            for (int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                int move = ny*3+nx;
                if (0<= ny && ny <3 && 0<= nx && nx <3){
                    StringBuilder sb = new StringBuilder(now);
                    char temp = sb.charAt(move);
                    sb.setCharAt(move,'9');
                    sb.setCharAt(nineIndex,temp);
                    int next = Integer.parseInt(sb.toString());
                    if (!map.containsKey(next)){
                        map.put(next, map.get(nowNum)+1);
                        q.offer(next);
                    }
                }
            }
        }
        if (map.containsKey(123456789)) {
            System.out.println(map.get(123456789));
        } else {
            System.out.println(-1);
        }
    }
}
