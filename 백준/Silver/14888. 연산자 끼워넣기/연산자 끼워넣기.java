import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] number;
    public static int[] operator = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        number = new int[N];
        for (int i=0;i<N;i++){
            number[i] = sc.nextInt();
        }
        for (int i=0; i<4; i++){
            operator[i]=sc.nextInt();
        }
        dfm(number[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfm(int num,int dex){
        if (dex==N){
            max=Math.max(max,num);
            min=Math.min(min,num);
            return;
        }
        for (int i=0;i<4;i++){
            if (operator[i]>0){
                operator[i]--;
                switch (i){
                    case 0 : dfm(num+number[dex],dex+1); break;
                    case 1 : dfm(num-number[dex],dex+1); break;
                    case 2 : dfm(num*number[dex],dex+1); break;
                    case 3 : dfm(num/number[dex],dex+1); break;
                }
                operator[i]++;
            }
        }
    }
}