import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<String> results;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        results = new ArrayList<>();
        int count = 0;
        DFS(count,"ICN","ICN",tickets);
        Collections.sort(results);
        return results.get(0).split(" ");
    }

    void DFS(int count , String present, String result ,String[][] tickets) {
        if (count == tickets.length){
            results.add(result);
            return;
        }
        for (int i = 0; i<tickets.length;i++){
            if (!visited[i] && tickets[i][0].equals(present)){
                visited[i] = true;
                DFS(count+1, tickets[i][1],result+" " +tickets[i][1],tickets);
                visited[i] = false;
            }
        }
    }
}