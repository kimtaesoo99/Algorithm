import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++){
            double n = sc.nextDouble();
            double m = sc.nextDouble();

            double a = 1;
            double b = 1;

            for (double j = m; j> m-n; j--){
                a = a*j;
            }
            for (double j = n; j> 0; j--){
                b = b*j;
            }
            double result = a/b;
            System.out.printf("%.0f \n",result);
        }
    }
}
