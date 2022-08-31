import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Ysum = 0;
        int Msum = 0;
        for (int i=0;i<N; i++){
            int a = sc.nextInt();
            int b = a;
            Ysum +=(a/30+1)*10;
            Msum +=(b/60+1)*15;
        }
        if (Ysum>Msum) System.out.printf("M %d",Msum);
        else if (Ysum<Msum) System.out.printf("Y %d",Ysum);
        else if (Ysum==Msum) System.out.printf("Y M %d",Ysum);
    }
}