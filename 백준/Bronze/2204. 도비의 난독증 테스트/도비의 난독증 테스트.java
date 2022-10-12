
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> hashMap = new HashMap<>();
        while (true){
            int n = sc.nextInt();
            if (n==0)break;
            String[] str = new String[n];
            for (int i= 0; i<n;i++){
                str[i] = sc.next();
            }
            for (int i =0;i<n;i++){
                String temp = str[i].toLowerCase();
                hashMap.put(temp,str[i]);
                str[i] = str[i].toLowerCase();
            }
            Arrays.sort(str);
            System.out.println(hashMap.get(str[0]));
        }

    }
}
