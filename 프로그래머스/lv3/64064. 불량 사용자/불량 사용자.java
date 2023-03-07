import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    static boolean[] visited;
    static List<String> results;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        results = new ArrayList<>();
        findBanCase(user_id, banned_id,0,"");
        Set<String> set = new HashSet<>();
        for (String r : results){
            String[] str = r.split(" ");
            set.add(Arrays.stream(str).sorted().collect(Collectors.joining()));
        }
        return set.size();
    }

    private void findBanCase(String[] user_id, String[] banned_id, int count, String result){
        if (count==banned_id.length){
            results.add(result);
            return;
        }

        for (int i = 0 ; i < user_id.length; i++){
            if (validation(user_id[i], banned_id[count]) && !visited[i]){
                visited[i] = true;
                findBanCase(user_id,banned_id,count+1,result+user_id[i]+" ");
                visited[i] = false;
            }
        }
    }

    private boolean validation(String user, String banned){
        if (user.length()!=banned.length())return false;
        for (int i = 0; i < user.length(); i++){
            if (user.charAt(i) == banned.charAt(i))continue;
            if (banned.charAt(i)=='*')continue;
            return false;
        }
        return true;
    }
}