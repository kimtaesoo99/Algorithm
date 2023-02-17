import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>=1023){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 10; i++) getDecreaseCount(i);
        Collections.sort(list);
        System.out.println(list.get(n));
    }

    public static void getDecreaseCount(long num){
        list.add(num);
        long crease = num%10;
        if (crease==0)return;

        for (long i = crease-1; i>=0; i--){
            getDecreaseCount(num*10+i);
        }
    }
}
