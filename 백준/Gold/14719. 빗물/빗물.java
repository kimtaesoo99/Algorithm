import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] map = new int[w];

        for (int i = 0; i < w; i++) {
            map[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 1; i < w-1; i++) {
            int left = 0;
            int right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, map[j]);
            }
            for (int j = i; j < w; j++) {
                right = Math.max(right, map[j]);
            }
            count += Math.min(left,right) - map[i];
        }
        System.out.println(count);
    }
}