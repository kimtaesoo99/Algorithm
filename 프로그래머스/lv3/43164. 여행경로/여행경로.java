import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    List<String> results;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        results = new ArrayList<>();
        visited = new boolean[tickets.length];
        getPath(tickets,"ICN", "ICN ",0);
        Collections.sort(results);
        return results.get(0).split(" ");
    }
    void getPath(String[][] tickets, String start, String result,int index){
        if (index == tickets.length){
            results.add(result);
        }
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                getPath(tickets,tickets[i][1],result+tickets[i][1]+" ",index+1);
                visited[i] = false;
            }
        }
    }
}