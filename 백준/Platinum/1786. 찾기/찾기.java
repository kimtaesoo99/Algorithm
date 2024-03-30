import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String t = br.readLine(); // 본문
        String p = br.readLine(); // 패턴

        int[] table = new int[p.length()];

        int i = 1; // 본문 포인터
        int j = 0; // 패턴 포인터

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                table[i - 1] = j;
            } else {
                if (j > 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }

        i = 0; // 본문 포인터
        j = 0; // 패턴 포인터

        int count = 0;

        while (i < t.length()) {
            if (t.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == p.length()) {
                    count++;
                    sb.append(i - p.length() + 1).append(" ");
                    j = table[j - 1];
                }
            } else {
                if (j > 0){
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}