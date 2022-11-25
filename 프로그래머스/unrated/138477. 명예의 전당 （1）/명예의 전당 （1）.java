 import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public  List<Integer>  solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>(); //명예의 전당
        List<Integer> minOfDay = new ArrayList<>();

        for (int i =0;i<score.length;i++){
            list.add(score[i]);
            int a = list.stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(k)
                    .min(Integer::compare)
                    .orElse(0);

            minOfDay.add(a);
        }

        return minOfDay;
    }
}