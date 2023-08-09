import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for(int i = 0 ; i < n ; i ++) {
            points[i] = new Point(sc.nextLong(), sc.nextLong());
        }

        Point zeroPoint = new Point(0, 0);
        double ans = 0;
        for(int i = 1 ; i < n ; i ++) {
            ans += (double) ccw(points[i - 1], points[i], zeroPoint) / 2.0;
        }
        ans += (double) ccw(points[n - 1], points[0], zeroPoint) / 2.0;
        System.out.printf("%.1f",Math.abs(ans));
    }

    static long ccw(Point a, Point b, Point c) {
        return( a.x * b.y + b.x * c.y + c.x * a.y) - ( a.x * c.y + c.x * b.y + b.x * a.y);
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
