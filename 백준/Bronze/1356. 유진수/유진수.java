import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int k=1;
       loop:
       while (true){
            int sumfront=1;
            for (int i =0; i<N.length()-1; i++){
                sumfront *= (N.charAt(i)-'0');
            int sumend=1;
            for (int j=i+1; j<N.length(); j++){
                sumend *=(N.charAt(j)-'0');
                if (j==N.length()-1&&sumfront==sumend){
                    System.out.println("YES");
                    break loop;
                }
            }
            }
                System.out.println("NO");
                break;
        }

    }
}
