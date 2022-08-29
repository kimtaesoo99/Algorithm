import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i=N; ; i--){
        String s = String.valueOf(i);
            if (!s.contains("0")&&!s.contains("1")&&
                 !s.contains("2")&&!s.contains("3")&&
                    !s.contains("5")&&!s.contains("6")&&
                    !s.contains("8")&&!s.contains("9")) {
                System.out.println(i);
                break;
            }
        }

    }
}