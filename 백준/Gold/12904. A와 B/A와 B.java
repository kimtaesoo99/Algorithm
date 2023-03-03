import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder S = new StringBuilder(sc.next());
        StringBuilder T = new StringBuilder(sc.next());
        while (S.length() < T.length()){
            if (T.charAt(T.length()-1)=='A'){
                T.deleteCharAt(T.length()-1);
            }else {
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }
        System.out.println(S.toString().equals(T.toString())?1:0);
    }
}

