import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (first==0&&second==0)break;
            System.out.println(first>second?"Yes":"No");
        }
    }
}
