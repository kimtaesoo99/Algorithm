import java.io.*;
 public class Main {
     public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2,N)-1).append('\n');
        hanoi(1,2,3,N);
        System.out.println(sb);
    }
     static void hanoi(int from ,int m ,int to ,int N){
        if(N==0)return;
        hanoi(from, to, m, N-1);
        sb.append(from+" "+to+'\n');
        hanoi(m,from,to,N-1);
    }
 }

