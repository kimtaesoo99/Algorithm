import java.util.*;


class Main{
    static int[] dy ={-2,-1,1,2,2,1,-1,-2};
    static int[] dx ={1,2,2,1,-1,-2,-2,-1};
    static int[][] result;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int j = 0; j< t; j++){
            int i = sc.nextInt();
            result = new int[i][i];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            bfs(startY,startX);
            sb.append(result[Y][X]-1).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        result[y][x] = 1;

        while(!q.isEmpty()){
            int[] move = q.poll();

            for(int i = 0; i< 8; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if(0<=moveY && moveY <result.length && 0<=moveX && moveX<result.length){
                    if(result[moveY][moveX] == 0){
                        result[moveY][moveX] = result[move[0]][move[1]] +1;
                        q.offer(new int[]{moveY,moveX});
                    }
                }
            }
        }
    }
}


