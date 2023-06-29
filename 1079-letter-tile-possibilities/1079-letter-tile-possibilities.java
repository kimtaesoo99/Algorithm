import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<String> set;
    private boolean[] visited;
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        visited = new boolean[tiles.length()];
        comb(tiles, 0, tiles.length(), "");
        return set.size() - 1;
    }

    private void comb(String tiles, int now, int depth, String result) {
        set.add(result);
        if (depth == now) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(tiles, now + 1, depth, result + tiles.charAt(i));
                visited[i] = false;
            }
        }
    }
}