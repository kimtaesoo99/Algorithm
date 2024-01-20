import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < k; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }

        int l = sc.nextInt();

        Queue<DirInfo> info = new LinkedList<>();

        for (int i = 0; i < l; i++) {
            int time = sc.nextInt();
            info.add(new DirInfo(time, sc.next()));
        }

        Deque<Location> snake = new ArrayDeque<>();
        snake.add(new Location(0, 0));

        int nowDir = 0;
        int result = 0;

        while (true){
            if (!info.isEmpty() && info.peek().time == result) {
                DirInfo d = info.poll();
                if (d.dir.equals("D")) {
                    nowDir += 1;
                } else {
                    nowDir -= 1;
                }
                if (nowDir == 4) {
                    nowDir = 0;
                }
                if (nowDir == -1) {
                    nowDir = 3;
                }
            }

            Location head = snake.peekFirst();


            int moveY = head.y;
            int moveX = head.x;

            if (nowDir == 0) {
                moveX++;
            } else if (nowDir == 1) {
                moveY++;
            } else if (nowDir == 2) {
                moveX--;
            } else {
                moveY--;
            }

            if (!correctMove(moveY, n, moveX) || snake.contains(new Location(moveY, moveX))) {
                break;
            }

            snake.addFirst(new Location(moveY, moveX));
            Location tail = snake.pollLast();

            if (map[moveY][moveX] == 1) {
                snake.addLast(tail);
                map[moveY][moveX] = 0;
            }

            result++;
        }

        System.out.println(result + 1);
    }

    private static boolean correctMove(int moveY, int n, int moveX) {
        return 0 <= moveY && moveY < n && 0 <= moveX && moveX < n;
    }
}

class DirInfo {

    int time;
    String dir;

    public DirInfo(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }
}

class Location {
    int y;
    int x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return y == location.y && x == location.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public String toString() {
        return "Location{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}

