import java.util.Arrays;

class Solution {
    static char[][] map;
    static int nowY;
    static int nowX;

    public int[] solution(String[] park, String[] routes) {
        map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();
        }
        loop:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    nowY = i;
                    nowX = j;
                    break loop;
                }
            }
        }
        dfs(routes);
        return new int[]{nowY, nowX};
    }

    private void dfs(String[] routes) {
        for (String r : routes) {
            String[] info = r.split(" ");
            String direct = info[0];
            int count = Integer.parseInt(info[1]);
            findMoveDirect(direct, count);
            System.out.println(nowY + " " + nowX);
        }
    }

    private void findMoveDirect(String direct, int count) {
        int moveY = nowY;
        int moveX = nowX;
        for (int i = 0; i < count; i++) {
            switch (direct) {
                case "E":
                    moveX++;
                    break;
                case "W":
                    moveX--;
                    break;
                case "S":
                    moveY++;
                    break;
                default:
                    moveY--;
                    break;
            }
            if (!move(moveY, moveX)) {
                return;
            }
        }
        nowY = moveY;
        nowX = moveX;
    }

    private boolean move(int y, int x) {
        if (0 <= y && y < map.length && 0 <= x && x < map[0].length) {
            if (map[y][x] == 'O' || map[y][x] == 'S') {
                return true;
            }
        }
        return false;
    }
}