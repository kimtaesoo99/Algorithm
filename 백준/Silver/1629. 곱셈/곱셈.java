import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(getDivision(a,b,c));
    }

    public static long getDivision(long a, long b, long c){
        if (b==1)return a%c;
        long temp  = getDivision(a, b / 2, c);
        if (b%2==1)return (temp*temp%c)*a%c;
        return temp*temp%c;
    }
}