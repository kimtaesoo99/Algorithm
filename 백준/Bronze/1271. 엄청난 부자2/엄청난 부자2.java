import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger result = new BigInteger("0");
        BigInteger result2 = new BigInteger("0");
        result = a.divide(b);
        result2 = a.mod(b);
        System.out.println(result);
        System.out.println(result2);


    }
}