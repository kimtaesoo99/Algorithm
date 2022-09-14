
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  str = sc.nextLine();

        for (int i=0;i<str.length(); i++){
            char C = str.charAt(i);
            if (Character.isUpperCase(C)){
                System.out.print(String.valueOf(C).toLowerCase());
            }
            else {
                System.out.print(String.valueOf(C).toUpperCase());
            }
        }
    }
}
