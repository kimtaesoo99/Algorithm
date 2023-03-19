import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n>1023){
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <=9; i++){
            getValue(i);
        }
        Collections.sort(list);
        System.out.println(list.get(n-1));
    }

    private static void getValue(long num){
        list.add(num);
        long start = num%10;
        for (long i = start-1; i >= 0; i--){
            getValue(num*10 + i);
        }
    }
}