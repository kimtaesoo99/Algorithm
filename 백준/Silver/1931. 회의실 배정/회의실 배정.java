import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> time = new ArrayList<>();
        for(int i = 0; i< n;i++){
            String[] info = br.readLine().split(" ");
            time.add(new Time(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
        }
        Collections.sort(time);
        int count = 0;
        int end = 0;
        for(int i = 0; i < time.size(); i++){
            if(end <= time.get(i).start){
                count++;
                end = time.get(i).end;
            }
        }
        System.out.println(count);
    }
}

class Time implements Comparable<Time>{
    int start;
    int end;

    @Override
    public int compareTo(Time t){
        if(this.end == t.end)return this.start - t.start;
        return this.end - t.end;
    }

    public Time(int start, int end){
        this.start = start;
        this.end = end;
    }
}
