import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
        static int count = 0;
        static int arrcount = 0;
        static int[] arr;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            fib(n);
            arr=new int[n];
            fibonacci(n);
            System.out.println(count);
            System.out.println(arrcount);
        }

        public static int fib(int n){
            if(n==1||n==2){
                count++;
                return 1;
            }
            return fib(n-1)+fib(n-2);
        }
        public static int fibonacci(int n){
            arr[0]=1;
            arr[1]=1;
            for (int i=2; i<n; i++){
                arr[i]=arr[i-1]+arr[i-2];
                arrcount++;
            }
            return arr[n-1];
        }
    }