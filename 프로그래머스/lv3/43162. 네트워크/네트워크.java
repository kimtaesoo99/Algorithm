class Solution {
    static boolean[] check;
    public int solution(int n, int[][] computers) {
        int count = 0;
        check = new boolean[n];
        for (int i = 0; i < computers.length; i++){
            if (!check[i]){
                getNetwork(i,computers);
                count++;
            }
        }
        return count;
    }
    void getNetwork(int i, int[][] computers){
        check[i] = true;
        for (int j = 0; j <computers.length; j++){
            if (i!=j && !check[j]&&computers[i][j] ==1){
                getNetwork(j,computers);
            }
        }
    }
}