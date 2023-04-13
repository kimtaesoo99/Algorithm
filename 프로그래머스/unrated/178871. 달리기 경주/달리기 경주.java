import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameWithRank = new HashMap<>();
        Map<Integer, String> rankWithName = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            nameWithRank.put(players[i], i);
            rankWithName.put(i, players[i]);
        }

        for (String c : callings) {
            int rank = nameWithRank.get(c);
            String preName = rankWithName.get(rank - 1);

            nameWithRank.put(c, rank-1);
            rankWithName.put(rank-1, c);

            nameWithRank.put(preName, rank);
            rankWithName.put(rank, preName);
        }
        String[] result = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            result[i] = rankWithName.get(i);
        }
        return result;
    }
}