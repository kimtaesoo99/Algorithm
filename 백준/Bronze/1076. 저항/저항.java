import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr ={"black", "brown", "red","orange","yellow","green","blue","violet","grey","white"};

        String a1 = sc.next();
        String a2 = sc.next();
        String a3 = sc.next();
        long a11=0;
        long a22=0;
        long a33=0;
        for (int i = 0; i<arr.length; i++){
            if (a1.equals(arr[i]))a11 = i;
            if (a2.equals(arr[i]))a22 = i;
            if (a3.equals(arr[i]))a33 = i;
        }
        long sum = (a11*10+a22)*(int)Math.pow(10,a33);

        System.out.println(sum);

    }
}
