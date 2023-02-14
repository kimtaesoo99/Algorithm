
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue q = new LinkedList();
        int N =sc.nextInt();

        for (int i=1;i<=N; i++){
            q.offer(i);
        }

        while(true){
            if(N==1)break;
            q.poll();
            N--;
            if(N==1)break;
            q.offer(q.poll());

        }
        System.out.println(q.peek());
    }
}