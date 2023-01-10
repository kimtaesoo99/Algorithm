class Solution {
    static int max = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        getMax(k, dungeons,0);
        return max;
    }

    static void getMax(int k, int[][] dungeons,int count) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                getMax(k-dungeons[i][1] , dungeons,count+1);
                visited[i] = false;
            }
        }
        max = Math.max(max,count);
    }
}