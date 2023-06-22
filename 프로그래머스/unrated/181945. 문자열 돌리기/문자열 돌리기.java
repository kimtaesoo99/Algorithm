import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Arrays.stream(a.split(""))
            .forEach(System.out::println);
    }
}