import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long sum = 0;
        int count = 0;
        for (int i = 1; i <= S; i++){
            sum+=i;
            if (sum>S){
                count=i;
                break;
            }
        }
        if (S == 1) System.out.println(1);
        else System.out.println(count-1);
    }
}
