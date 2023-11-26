import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    private int n;
    private int m;
    private int[] dy = {1, 0, -1, 0};
    private int[] dx = {0, -1, 0, 1};

    public int solution(int[][] maze) {
        int[] redBall = new int[2];
        int[] blueBall = new int[2];
        int[] redGoal = new int[2];
        int[] blueGoal = new int[2];

        n = maze.length;
        m = maze[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    redBall[0] = i;
                    redBall[1] = j;
                }
                if (maze[i][j] == 2) {
                    blueBall[0] = i;
                    blueBall[1] = j;
                }
                if (maze[i][j] == 3) {
                    redGoal[0] = i;
                    redGoal[1] = j;
                }
                if (maze[i][j] == 4) {
                    blueGoal[0] = i;
                    blueGoal[1] = j;
                }
            }
        }

        return bfs(redBall, blueBall, redGoal, blueGoal, maze);
    }

    private int bfs(int[] redBall, int[] blueBall, int[] redGoal, int[] blueGoal, int[][] maze) {
        Queue<Info> q = new LinkedList<>();

        Map<String, Integer> m1 = new HashMap<>();
        m1.put("" + redBall[0] + redBall[1], 1);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("" + blueBall[0] + blueBall[1], 1);

        q.offer(new Info(redBall, blueBall, 0, m1, m2));

        while (!q.isEmpty()) {
            Info poll = q.poll();

            // 우선 종료조건 둘다 들어감
            if (poll.redBall[0] == redGoal[0] && poll.redBall[1] == redGoal[1]
                    && poll.blueBall[0] == blueGoal[0] && poll.blueBall[1] == blueGoal[1]) {
                return poll.count;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int moveRedY = poll.redBall[0] + dy[i];
                    int moveRedX = poll.redBall[1] + dx[i];
                    int moveBlueY = poll.blueBall[0] + dy[j];
                    int moveBlueX = poll.blueBall[1] + dx[j];

                    // 레드 공이 들어가면 자리 그대로
                    if ((poll.redBall[0] == redGoal[0] && poll.redBall[1] == redGoal[1])) {
                        moveRedY = poll.redBall[0];
                        moveRedX = poll.redBall[1];

                        if (poll.blueVisited.containsKey("" + moveBlueY + moveBlueX)) {
                            continue;
                        }
                    } else if ((poll.blueBall[0] == blueGoal[0] && poll.blueBall[1] == blueGoal[1])) {
                        // 블루 공이 들어가면 자리 그대로
                        moveBlueY = poll.blueBall[0];
                        moveBlueX = poll.blueBall[1];

                        if (poll.redVisited.containsKey("" + moveRedY + moveRedX)) {
                            continue;
                        }
                    } else {
                        // 방문 여부 체크
                        if (poll.blueVisited.containsKey("" + moveBlueY + moveBlueX)
                                || poll.redVisited.containsKey("" + moveRedY + moveRedX)) {
                            continue;
                        }
                    }

                    // 범위를 벗어나면 제외
                    if (!(0 <= moveRedX && moveRedX < m && 0 <= moveRedY && moveRedY < n && 0 <= moveBlueX
                            && moveBlueX < m && 0 <= moveBlueY && moveBlueY < n)) {
                        continue;
                    }

                    // 서로 동선 겹치는지 체크
                    if ((moveBlueY == moveRedY && moveBlueX == moveRedX)) {
                        continue;
                    }

                    // 동시에 서로의 이전값으로 이동(교차)
                    if (poll.redBall[0] == moveBlueY && poll.redBall[1] == moveBlueX
                            && poll.blueBall[0] == moveRedY && poll.blueBall[1] == moveRedX) {
                        continue;
                    }

                    // 벽으로 이동도 안됨
                    if (maze[moveBlueY][moveBlueX] == 5 || maze[moveRedY][moveRedX] == 5) {
                        continue;
                    }

                    Map<String, Integer> redVisited = new HashMap<>(poll.redVisited);
                    Map<String, Integer> blueVisited = new HashMap<>(poll.blueVisited);

                    redVisited.put("" + moveRedY + moveRedX, 1);
                    blueVisited.put("" + moveBlueY + moveBlueX, 1);
                    q.offer(new Info(new int[]{moveRedY, moveRedX}, new int[]{moveBlueY, moveBlueX}, poll.count + 1,
                            redVisited, blueVisited));
                }
            }
        }
        return 0;
    }
}

class Info {
    int[] redBall;
    int[] blueBall;
    int count;

    Map<String, Integer> redVisited;
    Map<String, Integer> blueVisited;

    public Info(int[] redBall, int[] blueBall, int count, Map<String, Integer> redVisited,
                Map<String, Integer> blueVisited) {
        this.redBall = redBall;
        this.blueBall = blueBall;
        this.count = count;
        this.redVisited = redVisited;
        this.blueVisited = blueVisited;
    }
}
