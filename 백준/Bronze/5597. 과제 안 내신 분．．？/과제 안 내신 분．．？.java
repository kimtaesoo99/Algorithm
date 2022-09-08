
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       int[] arr = new int[31];
        for (int i=0;i<28;i++){
            int a= sc.nextInt();
            arr[a]++;
        }
        int[] result = new int[2];
        int index=0;
        for (int i=1; i<=30; i++){
            if (arr[i]==0){
                if (index==2)break;
                result[index]=i;
                index++;
            }
        }
        Arrays.sort(result);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
