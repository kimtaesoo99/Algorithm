class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] paint = new int[n+1];

        for (int s : section){
            paint[s] = -1;
        }
        for (int i = 1; i <= n; i++){
            if (paint[i]==-1){
                answer++;
                doPainting(paint,i,m);
            }
        }
        return answer;
    }

    private void doPainting(int[] paint, int index , int size){
        for (int i = index; i <index+ size; i++){
            if (i > paint.length-1)break;
            paint[i]++;
        }
    }
}
