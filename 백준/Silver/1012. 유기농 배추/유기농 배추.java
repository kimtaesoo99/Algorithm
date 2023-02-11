import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<test_case; i++){
            String[] num = br.readLine().split(" ");
            int M = Integer.parseInt(num[0]);
            int N = Integer.parseInt(num[1]);
            int K = Integer.parseInt(num[2]);
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j <K; j++){
                String[] line = br.readLine().split(" ");
                map[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = 1;
            }
            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(!visited[j][k]&& map[j][k]==1){
                        dfs(j,k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int moveY = y + dy[i];
            int moveX = x + dx[i];
            if (0<=moveY && moveY< map.length && 0<= moveX &&moveX <map[0].length)
            if(map[moveY][moveX]==1 && !visited[moveY][moveX]){
                dfs(moveY,moveX);
            }
        }

    }
}
