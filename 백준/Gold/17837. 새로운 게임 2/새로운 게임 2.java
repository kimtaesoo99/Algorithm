import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] chess = new int[n][n];
        Map<Location, List<Ware>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = sc.nextInt();
                map.put(new Location(i, j), new LinkedList<>());
            }
        }

        for (int i = 0; i < k; i++) {
            map.get(new Location(sc.nextInt() - 1, sc.nextInt() - 1)).add(new Ware(i, sc.nextInt() - 1));
        }

        int result = 1;

        loop:
        for (int i = 0; i < 1000; i++) {

            for (int j = 0; j < k; j++) {
                InfoTarget target = findTarget(j, n, map);

                Location location = target.location;
                List<Ware> wares = target.wares;

                int dir = wares.get(0).dir;

                int moveY = location.y + dy[dir];
                int moveX = location.x + dx[dir];

                Location next = new Location(moveY, moveX);

                if (!inMap(moveY, moveX, n) || chess[moveY][moveX] == 2) {
                    if (dir == 0) {
                        dir = 1;
                    } else if (dir == 1) {
                        dir = 0;
                    } else if (dir == 2) {
                        dir = 3;
                    } else {
                        dir = 2;
                    }

                    wares.get(0).dir = dir;

                    moveY = location.y + dy[dir];
                    moveX = location.x + dx[dir];

                    next = new Location(moveY, moveX);

                    if (!inMap(moveY, moveX, n) || chess[moveY][moveX] == 2) {
                        map.get(location).addAll(wares);

                        if (map.get(location).size() >= 4) {
                            break loop;
                        }
                        continue;
                    }
                }

                if (chess[moveY][moveX] == 0) {
                    map.get(next).addAll(wares);
                } else if (chess[moveY][moveX] == 1) {
                    Collections.reverse(wares);
                    map.get(next).addAll(wares);
                }

                if (map.get(next).size() >= 4) {
                    break loop;
                }
            }
            result++;
        }
        System.out.println(result >= 1000 ? -1 : result);
    }

    private static InfoTarget findTarget(int target, int n, Map<Location, List<Ware>> map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Location location = new Location(i, j);
                List<Ware> list = map.get(location);

                int index = list.indexOf(new Ware(target, 0));
                if (index != -1) {
                    List<Ware> result = new ArrayList<>(list.subList(index, list.size()));

                    if (list.size() > index) {
                        list.subList(index, list.size()).clear();
                    }

                    return new InfoTarget(location, result);
                }
            }
        }
        return null;
    }

    private static boolean inMap(int y, int x, int n) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

class InfoTarget {
    Location location;
    List<Ware> wares;

    public InfoTarget(Location location, List<Ware> wares) {
        this.location = location;
        this.wares = wares;
    }
}

class Ware {
    int num;
    int dir;

    public Ware(int num, int dir) {
        this.num = num;
        this.dir = dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ware ware = (Ware) o;
        return num == ware.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
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
}