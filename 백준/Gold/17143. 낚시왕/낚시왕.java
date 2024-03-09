import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static Shark[][] map;
    private static Shark[][] newMap;
    private static int y;
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        int sharkCount = Integer.parseInt(st.nextToken());

        map = new Shark[y + 1][x + 1];

        for (int i = 0; i < sharkCount; i++) {
            st = new StringTokenizer(br.readLine());
            int nowY = Integer.parseInt(st.nextToken()) - 1;
            int nowX = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            map[nowY][nowX] = new Shark(speed, dir, size);
        }

        int result = 0;
        for (int i = 0; i <= x; i++) {
            result += getShark(i);
            moveShark();
        }

        System.out.println(result);
    }

    private static int getShark(int nowIndex) {
        for (int i = 0; i <= y; i++) {
            if (map[i][nowIndex] != null) {
                int value = map[i][nowIndex].size;
                map[i][nowIndex] = null;
                return value;
            }
        }
        return 0;
    }

    private static void moveShark() {
        newMap = new Shark[y + 1][x + 1];

        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (map[i][j] != null) {
                    int speed = map[i][j].speed;
                    int dir = map[i][j].dir;
                    int size = map[i][j].size;

                    if (speed == 0) {
                        insertShark(i, j, speed, dir, size);
                        continue;
                    }

                    // 이동시켜주고
                    if (dir == 1) { //위
                        int cycle = 2 * y;
                        int dis = speed % cycle;

                        if (i >= dis) { // 남은거리가 처음 벽을 만나기 직전
                            insertShark(i - dis, j, speed, dir, size);
                            continue;
                        }

                        dis = dis - i;
                        if (dis <= y) { //방향을 바꾸고 남은거리가 벽을 안만나면
                            insertShark(dis, j, speed, 2, size);
                            continue;
                        }
                        dis -= y;
                        insertShark(y - dis, j, speed, dir, size);
                    } else if (dir == 2) { // 아래
                        int cycle = 2 * y;
                        int dis = speed % cycle;

                        if (y - i >= dis) {
                            insertShark(i + dis, j, speed, dir, size);
                            continue;
                        }

                        dis = dis - (y - i);
                        if (dis <= y) { //방향을 바꾸고 남은거리가 벽을 안만나면
                            insertShark(y - dis, j, speed, 1, size);
                            continue;
                        }

                        dis -= y;
                        insertShark(dis, j, speed, dir, size);
                    } else if (dir == 3) { // 오른쪽
                        int cycle = 2 * x;
                        int dis = speed % cycle; // 가야할 거리

                        if (x - j >= dis) { // 남은거리가 처음 벽을 만나기 직전
                            insertShark(i, j + dis, speed, dir, size);
                            continue;
                        }

                        dis = dis - (x - j);
                        if (dis <= x) { //방향을 바꾸고 남은거리가 벽을 안만나면
                            insertShark(i, x - dis, speed, 4, size);
                            continue;
                        }
                        dis -= x;
                        insertShark(i, dis, speed, dir, size);

                    } else if (dir == 4) { // 왼쪽
                        int cycle = 2 * x;
                        int dis = speed % cycle; // 가야할 거리

                        if (j >= dis) { // 남은거리가 처음 벽을 만나기 직전
                            insertShark(i, j - dis, speed, dir, size);
                            continue;
                        }

                        dis = dis - j;
                        if (dis <= x) { //방향을 바꾸고 남은거리가 벽을 안만나면
                            insertShark(i, dis, speed, 3, size);
                            continue;
                        }
                        dis -= x;
                        insertShark(i, x - dis, speed, dir, size);
                    }
                }
            }
        }

        // 원래 맵으로 넣어주기
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    //newMap에 넣을때 이미 있으면 크기 큰놈으로 바꾸기
    private static void insertShark(int y, int x, int speed, int dir, int size) {
        if (newMap[y][x] == null) {
            newMap[y][x] = new Shark(speed, dir, size);
        } else {
            int preSize = newMap[y][x].size;
            if (preSize < size) {
                newMap[y][x] = new Shark(speed, dir, size);
            }
        }
    }
}

class Shark {
    int speed;
    int dir;
    int size;

    public Shark(int speed, int dir, int size) {
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}