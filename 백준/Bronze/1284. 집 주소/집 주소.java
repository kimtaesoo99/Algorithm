import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            String N = sc.next();
            if (N.equals("0"))break;
            int count = 2+N.length()-1;

            for (int i =0; i<N.length(); i++){
                if (N.charAt(i)=='1')count+=2;
                else if (N.charAt(i)=='0')count+=4;
                else count+=3;
            }

            System.out.println(count);
        }


    }
}