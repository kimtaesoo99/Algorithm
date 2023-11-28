import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    private static final List<String> list = List.of("code", "date", "maximum", "remain");
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
                .filter(d -> d[list.indexOf(ext)] < val_ext)
                .sorted(Comparator.comparingInt(s -> s[list.indexOf(sort_by)]))
                .toArray(int[][]::new);
    }
}
