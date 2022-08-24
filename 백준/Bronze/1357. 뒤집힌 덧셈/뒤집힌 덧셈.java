import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();
        String XSumY = Rev((Integer.parseInt(Rev(X)) + Integer.parseInt((Rev(Y))))+"");

        System.out.println(XSumY);

    }
    static String Rev(String x){

        int sum=0;
        int a = Integer.parseInt(x);
        for (int i =0;i<x.length();i++){
            sum+=(a%10*(Math.pow(10,x.length()-1-i)));
            a=a/10;
        }
        return sum+"";
    }
}
