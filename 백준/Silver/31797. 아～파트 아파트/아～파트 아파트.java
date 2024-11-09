import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        List<Hand> list = new LinkedList<>();

        for (int i = 1; i <= m; i++) {
            String[] line = br.readLine().split(" ");
            list.add(new Hand(i, Integer.parseInt(line[0])));
            list.add(new Hand(i, Integer.parseInt(line[1])));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            Hand remove = list.remove(0);
            list.add(remove);
        }

        System.out.println(list.get(list.size() - 1).num);
    }
}

class Hand implements Comparable<Hand> {
    int num;
    int high;

    public Hand(int num, int high) {
        this.num = num;
        this.high = high;
    }

    @Override
    public int compareTo(Hand o) {
        return this.high - o.high;
    }
}