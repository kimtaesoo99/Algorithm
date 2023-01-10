import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    static int max = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        getMax(k, dungeons,0);
        return max;
    }

    static void getMax(int k, int[][] dungeons,int count) {
        List<Integer> notVisitedIndex = IntStream.rangeClosed(0,visited.length-1).filter(i ->!visited[i])
                .boxed().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< dungeons.length; i++){
            if (notVisitedIndex.contains(i))min = Math.min(min,dungeons[i][0]);
        }
        if (k<min){
            max = Math.max(max,count);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                getMax(k-dungeons[i][1] , dungeons,count+1);
                visited[i] = false;
            }
        }
    }
}