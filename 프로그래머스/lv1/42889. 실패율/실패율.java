import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public List<Integer> solution(int N, int[] stages) {
        HashMap<Integer, Integer> stageFailureCountMap = new HashMap<>();
        HashMap<Integer, Double> stageFailureMap = new HashMap<>();

        // 0. 초기화
        for (int i = 1; i <= N; i++) {
            stageFailureCountMap.put(i, 0);
            stageFailureMap.put(i, 0.0);
        }

        // 1. 실패율 구하기
        for (int stage : stages) {
            if (stage == N + 1) continue;
            stageFailureCountMap.put(stage, stageFailureCountMap.getOrDefault(stage, 0) + 1);
        }

        // 2. 실패율 계산하기
        int total = stages.length;
        for (int key : stageFailureCountMap.keySet()) {
            if (total == 0) {
                stageFailureMap.put(key, 0.0);
                continue;
            }
            stageFailureMap.put(key, (double) stageFailureCountMap.get(key) / total);
            total -= stageFailureCountMap.get(key);
        }

        // 3. 실패율 내림차순 정렬하기
        List<Integer> answer = stageFailureMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        return answer;
    }
}