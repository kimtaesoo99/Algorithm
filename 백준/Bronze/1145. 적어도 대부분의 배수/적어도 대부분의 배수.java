import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i=0;i<5;i++){
            arr[i] = sc.nextInt();
        }

        int result = 0;
        int min = 1;
       loop:while (true){
            int count =0;
            for (int i=0;i<5;i++){
                if (min%arr[i]==0)count++;
                if (count==3){
                    result=min;
                    break loop;
                }
            }
            min++;
        }
        System.out.println(result);
    }
}
