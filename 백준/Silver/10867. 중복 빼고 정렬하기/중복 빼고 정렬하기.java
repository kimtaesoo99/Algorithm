import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(info).distinct().mapToInt(Integer::parseInt)
                .sorted()
                .forEach(i-> sb.append(i).append(" "));
        System.out.println(sb.toString());
    }
}
