import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (list.get(list.size() - 1) < value) {
                list.add(value);
            }else {
                int left = 0;
                int right = list.size()-1;

                while (left<right){
                    int mid = (left+right)/2;
                    if (list.get(mid) >= value){
                        right = mid;
                    }else {
                        left = mid+1;
                    }
                }
                list.set(right,value);
            }
        }
        System.out.println(list.size()-1);
    }
}
