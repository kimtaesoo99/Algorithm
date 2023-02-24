import java.util.*;
class Solution {
    static boolean[] visited;
    static List<String> results = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        findPath("ICN","ICN",0,tickets);
        Collections.sort(results);
        return results.get(0).split(" ");
    }
    
    public void findPath(String now, String result, int index, String[][] tickets){
        if(index == tickets.length){
            results.add(result);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i]= true;
                findPath(tickets[i][1],result +" "+ tickets[i][1],index+1,tickets);
                visited[i] = false;
            }
        }
        
        
    }
}