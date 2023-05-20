import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int length = Math.min(picks[0] + picks[1] + picks[2],
                (minerals.length / 5) + ((minerals.length % 5 == 0) ? 0 : 1));
        int[] weight = new int[length];
        int index = 0;
        for (int i = 1; i <= Math.min(weight.length * 5, minerals.length); i++) {
            if (minerals[i - 1].equals("diamond")) {
                weight[index] += 25;
            } else if (minerals[i - 1].equals("iron")) {
                weight[index] += 5;
            } else if (minerals[i - 1].equals("stone")) {
                weight[index]++;
            }
            if (i % 5 == 0) {
                index++;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weight.length; i++) {
            map.put(i, weight[i]);
        }
        char[] pick = new char[weight.length];

        map.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(i -> {
                    if (picks[0] != 0) {
                        pick[i.getKey()] = 'd';
                        picks[0]--;
                    } else if (picks[1] != 0) {
                        pick[i.getKey()] = 'i';
                        picks[1]--;
                    } else {
                        pick[i.getKey()] = 's';
                    }
                });
        String resultPick = "";
        for (char p : pick) {
            resultPick += p;
        }
        int answer = 0;

        for (int i = 0; i < Math.min(weight.length * 5, minerals.length); i++) {
            char now = resultPick.charAt(i / 5);
            if (now == 'i' && minerals[i].equals("diamond")) {
                answer += 5;
            } else if (now == 's' && minerals[i].equals("diamond")) {
                answer += 25;
            } else if (now == 's' && minerals[i].equals("iron")) {
                answer += 5;
            } else {
                answer++;
            }
        }
        return answer;
    }
}