import java.util.*;

public class Main {

    private static int max = -1;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String str = sc.next();
            int k = sc.nextInt();

            int con3 = find3Con(str, k);
            int con4 = find4Con(str, k);

            if (con3 == -1 || con4 == -1) {
                sb.append(-1).append("\n");
            } else {
                sb.append(con3 + " " + con4).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int find3Con(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;

        while (left <= right) {
            if (inCount(map, k)) {
                map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0) - 1);
                left++;
                length = Math.min(length, right - left + 1);
            } else {
                if (right < str.length()) {
                    map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
                    right++;
                } else {
                    break;
                }
            }
        }

        return length == Integer.MAX_VALUE ? -1 : length;
    }


    private static int find4Con(String str, int k) {
        Map<Character, List<Integer>> map = new HashMap<>();
        max = 1;

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (!map.containsKey(now)) {
                map.put(now, new ArrayList<>());
            }
            map.get(now).add(i);
        }

        map.forEach((key, value) -> {
            if (value.size() >= k) {
                for (int j = k - 1; j < value.size(); j++) {
                    max = Math.max(max, value.get(j) - value.get(j - k + 1) + 1);
                }
            }
        });

        return max;
    }

    private static boolean inCount(Map<Character, Integer> map, int k) {
        return map.entrySet()
                .stream()
                .anyMatch(i -> i.getValue() >= k);
    }
}