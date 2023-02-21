import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(tickets,0, "ICN","ICN");
        Collections.sort(list);
        return list.get(0).split(" ");
       
    }
    
    public void dfs(String[][] tickets, int index, String pre ,String result){
        if(index == visited.length){
            list.add(result);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && pre.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets, index+1, tickets[i][1] , result+" " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}