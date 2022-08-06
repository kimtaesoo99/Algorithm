import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String binary = Integer.toBinaryString(N);
        int count=0;
        for (int i = 0; i<binary.length(); i++){
            if (binary.charAt(i)=='1')count++;
        }
        System.out.println(count);
    }
}