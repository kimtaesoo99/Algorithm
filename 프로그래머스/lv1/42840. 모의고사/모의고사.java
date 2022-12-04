
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] answers) {
        return getMax(answers);
    }

    private List<Integer> getMax(int[] answers) {
        int firstCount = getCount(answers, new int[]{1, 2, 3, 4, 5});
        int secondCount = getCount(answers, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        int thirdCount = getCount(answers, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int max = findMax(firstCount, secondCount, thirdCount);
        List<Integer> list = new ArrayList<>();
        if (max == firstCount) {
            list.add(1);
        }
        if (max == secondCount) {
            list.add(2);
        }
        if (max == thirdCount) {
            list.add(3);
        }

        return list;
    }


    private int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int getCount(int[] answer, int[] ints) {
        int count = 0;
        int index = 0;
        for (int problem : answer) {
            if (problem == ints[index % ints.length]) {
                count++;
            }
            index++;
        }
        return count;
    }

}
