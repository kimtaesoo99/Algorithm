import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    static boolean[] visited;
    static List<Integer> resultLength;

    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        resultLength = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                dfs(i, 0, cards);
            }
        }
        if (resultLength.size() < 2){
            return 0;
        }
        return resultLength.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(1,(s1, s2) -> s1 * s2);
    }

    private void dfs(int n, int count, int[] cards) {
        if (visited[cards[n] - 1]) {
            resultLength.add(count);
            return;
        }
        visited[cards[n] - 1] = true;
        dfs(cards[n] - 1, count + 1, cards);
    }
}