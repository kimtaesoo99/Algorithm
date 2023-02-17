import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        int m = sc.nextInt();
        int d = sc.nextInt();

        int c = d-1;
        for(int i = 0; i < m-1; i++){
            c+=month[i];
        }
        System.out.println(day[c%7]);

    }
}
