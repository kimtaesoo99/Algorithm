import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> word = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!word.contains(str)) {
                word.add(str);
            }
        }

        int max = Integer.MIN_VALUE;
        int wordA = 0;
        int wordB = 0;

        for (int i = 0; i < word.size() - 1; i++) {
            String str1 = word.get(i);
            for (int j = i + 1; j < word.size(); j++) {
                int count = 0;
                String str2 = word.get(j);

                int len = Math.min(str1.length(), str2.length());
                for (int l = 0; l < len; l++) {
                    if (str1.charAt(l) != str2.charAt(l)) {
                        break;
                    }
                    count++;
                }

                if (max < count) {
                    max = count;
                    wordA = i;
                    wordB = j;
                }
            }
        }

        System.out.println(word.get(wordA));
        System.out.println(word.get(wordB));
    }
}