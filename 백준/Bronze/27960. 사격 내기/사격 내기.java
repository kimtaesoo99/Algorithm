import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        int a = Integer.parseInt(info[0]);
        int b = Integer.parseInt(info[1]);

        System.out.println(a ^ b);

    }
}