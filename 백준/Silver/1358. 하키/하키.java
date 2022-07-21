import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int W =sc.nextInt();
        int H =sc.nextInt();
        int X =sc.nextInt();
        int Y =sc.nextInt();
        int P =sc.nextInt();

        int count=0;
        for(int i=0; i<P; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            double distance1 = Math.sqrt(Math.pow(X-x,2)+Math.pow(Y+H/2-y,2));
            double distance2 = Math.sqrt(Math.pow(X+W-x,2)+Math.pow(Y+H/2-y,2));
            if(X<=x&&x<=X+W && Y<=y&&y<=Y+H)count++;
            else {
                if(distance1<=H/2||distance2<=H/2)count++;
            }
            

        }
        System.out.println(count);
    }
}