import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private final List<int[]> results = new ArrayList<>();
    private int[] ryan;
    private int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        dfs(n, 0, info, 0);

        if (maxDiff == 0) {
            return new int[]{-1};
        }

        Collections.sort(results, (s1, s2) -> {
            for (int i = 10; i >= 0; i--) {
                if (s1[i] != s2[i]) {
                    return s2[i] - s1[i];
                }
            }
            return 0;
        });

        return results.get(0);
    }

    private void dfs(int n, int index, int[] info, int start) {
        if (n == index) {
            compare(info);
            return;
        }

        for (int i = start; i < 11; i++) {
            ryan[i]++;
            dfs(n, index + 1, info, i);
            ryan[i]--;
        }
    }

    private void compare(int[] info) {
        int ryan_point = 0;
        int apeach_point = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) {
                continue;
            }
            if (info[i] < ryan[i]) {
                ryan_point += (10 - i);
            } else {
                apeach_point += (10 - i);
            }
        }

        if (ryan_point - apeach_point > maxDiff) {
            results.clear();
            results.add(ryan.clone());
            maxDiff = ryan_point - apeach_point;
        } else if (ryan_point - apeach_point == maxDiff) {
            results.add(ryan.clone());
        }
    }
}