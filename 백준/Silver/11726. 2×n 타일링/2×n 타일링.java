import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rectangle = new int[n+1];
        rectangle[1] = 1;
        if(n>=2)rectangle[2] = 2;

        for (int i = 3; i < rectangle.length; i++) {
            rectangle[i] = (rectangle[i - 1] + rectangle[i - 2])%10007;
        }

        System.out.println(rectangle[n]);
    }
}