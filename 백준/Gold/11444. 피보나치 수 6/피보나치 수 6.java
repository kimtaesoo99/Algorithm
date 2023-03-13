import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    final static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());

        if(N == 1 || N == 0) {
            System.out.println(N);
            return;
        }

        N--;

        long[][] origin = {{1, 1},{1, 0}};
        long[][] A = {{1, 0},{0, 1}};
       
        while(N > 0) {
            if(N % 2 == 1) {	
                A = multiply(A, origin);
            }
            origin = multiply(origin, origin);

            N /= 2;
        }
        System.out.println(A[0][0]);
    }

    public static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
        return ret;
    }
}
