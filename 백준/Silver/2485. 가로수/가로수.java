
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree= new int[n];
        int[] gaps = new int[n-1];
        for (int i=0;i<n; i++){
            tree[i] =sc.nextInt();
            if (i>0){
                gaps[i-1] = tree[i]-tree[i-1];
            }
        }
        for (int i=0; i<gaps.length-1;i++){
            gaps[i+1] = gcd(gaps[i],gaps[i+1]);
        }
        int gap = gaps[gaps.length-1];
        System.out.println((tree[n-1]-tree[0])/gap-n+1);


    }
    static int gcd(int a, int b){
        while (b>0){
            int temp =a;
            a=b;
            b=temp%b;
        }
        return a;
    }
}