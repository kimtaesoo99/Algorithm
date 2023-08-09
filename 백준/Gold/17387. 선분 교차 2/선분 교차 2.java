import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point a = new Point(sc.nextLong(), sc.nextLong());
        Point b = new Point(sc.nextLong(), sc.nextLong());
        Point c = new Point(sc.nextLong(), sc.nextLong());
        Point d = new Point(sc.nextLong(), sc.nextLong());

        int res1 = ccw(a, b, c) * ccw(a, b, d);
        int res2 = ccw(c, d, a) * ccw(c, d, b);

        if (res1 == 0 && res2 == 0) {
            if (Math.min(a.x, b.x) <= Math.max(c.x, d.x) && Math.min(c.x, d.x) <= Math.max(a.x, b.x) &&
                    Math.min(a.y, b.y) <= Math.max(c.y, d.y) && Math.min(c.y, d.y) <= Math.max(a.y, b.y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (res1 <= 0 && res2 <= 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static int ccw(Point a, Point b, Point c) {
        long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + c.x * b.y + b.x * a.y);
        if (result == 0) {
            return 0;
        } else if (result > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
