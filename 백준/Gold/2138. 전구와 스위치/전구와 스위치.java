import java.util.Scanner;

public class Main {
    static int N;
    static char[][] before;
    static char[] after;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        before = new char[2][N];
        after = new char[N];
        before[0] = sc.next().toCharArray();
        after = sc.next().toCharArray();

        for (int i = 0; i < N; i++) before[1][i] = before[0][i];

        getBulb(0,1,0);

        turnOnOff(1,0);

        getBulb(1,1,1);
        System.out.println(min==Integer.MAX_VALUE?"-1":min);
    }

    public static void turnOnOff(int cur, int index){
        for (int i = index-1; i< index+2; i++){
            if (0<=i && i <N){
                before[cur][i] = before[cur][i]=='0'?'1':'0';
            }
        }
    }

    public static void getBulb(int cur, int index, int count){
        if (N==index){
            if (after[N - 1] == before[cur][N - 1]) min =  Math.min(min, count);
            return;
        }
        if (after[index-1] != before[cur][index-1]){
            turnOnOff(cur,index);
            getBulb(cur,index+1,count+1);
        }else getBulb(cur,index+1,count);
    }
}
