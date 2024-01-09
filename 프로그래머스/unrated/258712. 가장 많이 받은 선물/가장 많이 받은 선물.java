import java.util.*;

class Solution {

    private List<String> list;
    private int[][] map;
    private int[] count;

    public int solution(String[] friends, String[] gifts) {
        map = new int[friends.length][friends.length];
        count = new int[friends.length];
        list = new LinkedList<>();

        Collections.addAll(list, friends);

        for (String g : gifts) {
            String[] split = g.split(" ");
            String from = split[0];
            String to = split[1];

            int fromIndex = list.indexOf(from);
            int toIndex = list.indexOf(to);

            map[fromIndex][toIndex]++;
        }

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }
                compare(i, j);
            }
        }

        return Arrays.stream(count)
                .max()
                .orElse(0) / 2;
    }

    private void compare(int from, int to) {
        if (map[from][to] > map[to][from]) {
            count[from]++;
        } else if (map[from][to] < map[to][from]) {
            count[to]++;
        } else {
            int fromValue = getSum(from);
            int toValue = getSum(to);

            if (fromValue > toValue){
                count[from]++;
            }
            if (fromValue < toValue){
                count[to]++;
            }
        }
    }

    private int getSum(int value){
        int add = 0;
        int minus = 0;

        for (int i = 0; i < count.length; i++){
            add += map[value][i];
        }

        for (int i = 0; i < count.length; i++){
            minus += map[i][value];
        }

        return add - minus;
    }
}
