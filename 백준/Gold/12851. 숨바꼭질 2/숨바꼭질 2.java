import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static int count;
    static int[] time;
    static int MIN_TIME=Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n>=k){
            System.out.println(n-k);
            System.out.println(1);
            return;
        }
        bfs(n,k);
        System.out.println(time[k]);
        System.out.println(count);
    }

    public static void bfs(int start, int end){
        time = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);


        while (!q.isEmpty()){
            Integer now = q.poll();
            int next;
            if (MIN_TIME < time[now])return;
            for (int i = 0; i <= 2; i++){
                if (i==0)next = now-1;
                else if (i==1) next = now+1;
                else next = now*2;

                if (0 > next || next>100000)continue;

                if (next == end){
                    count++;
                    MIN_TIME = time[now];
                }

                if (time[next] == 0 || time[next] == time[now] + 1){
                    q.add(next);
                    time[next] = time[now] +1;
                }
            }
        }
    }
}
