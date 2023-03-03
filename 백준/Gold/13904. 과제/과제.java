import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Work> workList = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            workList.add(new Work(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
            maxDay = Math.max(maxDay, Integer.parseInt(info[0]));
        }
        int sum = 0;
        for (int i = maxDay; i>=1; i--){
            int maxIndex = -1;
            int maxValue = 0;
            for (int j = 0; j < workList.size(); j++){
                if (workList.get(j).day >=i){
                    if (workList.get(j).score > maxValue){
                        maxValue = workList.get(j).score;
                        maxIndex = j;
                    }
                }
            }
            sum += maxValue;
            if (maxIndex!=-1) workList.remove(maxIndex);
        }
        System.out.println(sum);
    }
}

class Work{
    int day;
    int score;

    public Work(int day, int score) {
        this.day = day;
        this.score = score;
    }
}
