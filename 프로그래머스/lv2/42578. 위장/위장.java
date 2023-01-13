import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            List<String> list = map.getOrDefault(clothe[1], new LinkedList<>());
            list.add(clothe[0]);
            map.put(clothe[1], list);
        }
        int combination = 1;
        List<Integer> sizes = map.values().stream().map(List::size)
                .collect(Collectors.toList());
        for (Integer size : sizes) {
            combination *=(size+1);
        }
        return combination-1;
    }
}