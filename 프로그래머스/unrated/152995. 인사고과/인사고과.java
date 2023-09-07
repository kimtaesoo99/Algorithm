import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] scores) {
        int max = 0;
        int[] target = scores[0];
        Arrays.sort(scores, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));

        List<Integer> list = new ArrayList<>();

        for (int[] score : scores) {

            if (score[1] < max) {
                if (Arrays.equals(score, target)) {
                    return -1;
                }
            } else {
                list.add(score[0] + score[1]);
                max = score[1];
            }
        }

        list.sort(Collections.reverseOrder());

        return list.indexOf(target[0] + target[1]) + 1;
    }
}
