import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static String[][] relation;
    static Set<String> keys;

    public int solution(String[][] relation) {
        this.relation = relation;
        keys = new HashSet<>();
        int columnLength = relation[0].length;
        combination(0, columnLength, new boolean[columnLength], "", -1);
        return findKey();
    }

    private void combination(int index, int columnLength, boolean[] visited, String com, int pre) {
        if (validationKey(com)) {
            keys.add(com);
        }
        if (index == columnLength) {
            return;
        }
        for (int i = 0; i < columnLength; i++) {
            if (!visited[i] && pre < i) {
                visited[i] = true;
                combination(index + 1, columnLength, visited, com + i, i);
                visited[i] = false;
            }
        }
    }

    private boolean validationKey(String com) {
        Set<String> check = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder now = new StringBuilder();
            for (int j = 0; j < com.length(); j++) {
                int index = com.charAt(j) - '0';
                now.append(relation[i][index]);
            }
            check.add(now.toString());
        }
        return check.size() == relation.length;
    }

    private int findKey() {
        List<String> list = new ArrayList<>(keys);
        int[] visited = new int[keys.size()];
        for (String key : keys) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(key)) {
                    continue;
                }
                if (checkContain(list.get(i), key)) {
                    visited[i]++;
                }
            }
        }
        return (int) Arrays.stream(visited).filter(i -> i == 0).count();
    }

    private boolean checkContain(String value, String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!value.contains(String.valueOf(key.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}