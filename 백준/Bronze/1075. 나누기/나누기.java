import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();
        int num =N/100*100;

        int count = 0;
        for (int i = num; i<num+100; i++){
            if (i%F==0){
                count = i;
                break;
            }
        }
        int count2 = count%100;
        if (count2<10) System.out.printf("0%d",count2);
        else System.out.println(count2);

    }
}