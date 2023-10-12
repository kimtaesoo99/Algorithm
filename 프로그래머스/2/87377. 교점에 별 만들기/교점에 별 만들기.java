import java.util.HashSet;
import java.util.Set;

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {

        Set<Point> set = new HashSet<>();

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {

                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a * d - b * c;
                if (adbc == 0) {
                    continue;
                }

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) {
                    continue;
                }

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) {
                    continue;
                }

                long x = bfed / adbc;
                long y = ecaf / adbc;

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

                set.add(new Point(x, y));
            }
        }

        boolean[][] map = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (Point p : set) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);

            map[y][x] = true;
        }

        String[] result = new String[map.length];
        StringBuilder sb;

        for (int i = 0; i < map.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }
}