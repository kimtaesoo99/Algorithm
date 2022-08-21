import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        while (true){
            int count=0;
            String str = sc.nextLine();
            if (str.equals("#"))break;
            for (int i =0;i<str.length(); i++){
                if (str.charAt(i)=='a') count++;
                if (str.charAt(i)=='o') count++;
                if (str.charAt(i)=='u') count++;
                if (str.charAt(i)=='e') count++;
                if (str.charAt(i)=='i') count++;
                if (str.charAt(i)=='I') count++;
                if (str.charAt(i)=='O') count++;
                if (str.charAt(i)=='U') count++;
                if (str.charAt(i)=='E') count++;
                if (str.charAt(i)=='A') count++;


            }
                System.out.println(count);
        }

    }
}