import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    private List<Integer> answer = new ArrayList<>();
    private boolean[] visited;
    private int max = 0;

    public int[] solution(int[][] dice) {
        visited = new boolean[dice.length];
        combination(dice, 0, new int[dice.length / 2], -1);

        return answer.stream()
                .mapToInt(i -> i + 1)
                .toArray();
    }

    private void combination(int[][] dice, int index, int[] now, int pre) {
        if (index == dice.length / 2) {
            List<Integer> firstDice = getSumOfDice(dice, now);

            int[] remainDice = findRemainDice(now);
            List<Integer> secondDice = getSumOfDice(dice, remainDice);

            Collections.sort(firstDice);
            Collections.sort(secondDice);

            int result = 0;

            for (int f : firstDice) {
                result += findIndex(f, secondDice);
            }

            if (max < result) {
                max = result;
                answer.clear();
                Arrays.stream(now).forEach(i -> answer.add(i));
            }
            return;
        }

        for (int i = 0; i < dice.length; i++) {
            if (!visited[i] && i > pre) {
                visited[i] = true;
                now[index] = i;
                combination(dice, index + 1, now, i);
                visited[i] = false;
            }
        }
    }

    private int[] findRemainDice(int[] now) {
        int[] dice = new int[now.length];

        int index = 0;
        for (int i = 0; i < now.length * 2; i++) {
            if (!contains(now, i)) {
                dice[index++] = i;
            }
        }

        return dice;
    }

    private boolean contains(int[] now, int i) {
        return Arrays.stream(now)
                .anyMatch(n -> n == i);
    }

    private List<Integer> getSumOfDice(int[][] dice, int[] now) {
        List<Integer> sum = new ArrayList<>();
        addSum(dice, now, sum, 0, 0);
        return sum;
    }

    private void addSum(int[][] dice, int[] now, List<Integer> list, int index, int sum) {
        if (index == now.length) {
            list.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            addSum(dice, now, list, index + 1, sum + dice[now[index]][i]);
        }
    }

    private int findIndex(int now, List<Integer> list) {
        int left = 0;
        int right = list.size();

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < now) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}