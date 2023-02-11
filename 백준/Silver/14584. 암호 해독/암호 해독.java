import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        String crypto = sc.next();
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(sc.next());
        }
        StringBuilder sb = new StringBuilder();

        loop: for (int j = 0; j < 26; j++) {
            sb = new StringBuilder();
            for (int i = 0; i < crypto.length(); i++) {
                int word = crypto.charAt(i) + j;
                if (word>122)word-=26;
                sb.append((char) word);
            }
            for (String s : list) {
                if (sb.toString().contains(s))break loop;
            }
        }
        System.out.println(sb);
    }
}
