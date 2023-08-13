import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer>[] tree;
    static int maxSheepCount = 0;

    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        dfs(0, 0, 0, info, new ArrayList<>(0));

        return maxSheepCount;
    }


    private void dfs(int now, int sheepCount, int wolfCount, int[] info, List<Integer> nextInfo) {
        if (info[now] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }

        if (sheepCount <= wolfCount) {
            return;
        }
        maxSheepCount = Math.max(maxSheepCount, sheepCount);

        List<Integer> list = new ArrayList<>(nextInfo);
        list.remove(Integer.valueOf(now));
        list.addAll(tree[now]);

        for (int next : list) {
            dfs(next, sheepCount, wolfCount, info, list);
        }
    }
}