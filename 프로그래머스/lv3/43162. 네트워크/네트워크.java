class Solution {
    static int count = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers.length; j++){
                if(!visited[i] && computers[i][j]==1){
                    findNetwork(j,computers);
                    count++;
                }
            }
        }
        return count;
    }
    public void findNetwork(int index, int[][] computers){
        visited[index] = true;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]&& computers[index][i]==1){
                findNetwork(i , computers);
            }
        }
    }
}