import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        BigInteger Ab = new BigInteger(A, 2);
        BigInteger Bb = new BigInteger(B, 2);

        BigInteger sum = Ab.add(Bb);

        String sum_binary = sum.toString(2);

        System.out.println(sum_binary);
    }

}