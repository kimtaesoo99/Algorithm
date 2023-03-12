import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        Gem[] gems = new Gem[N];
        for (int i = 0; i < N; i++){
            String[] gemInfo = br.readLine().split(" ");
            int w = Integer.parseInt(gemInfo[0]);
            int c = Integer.parseInt(gemInfo[1]);
            gems[i] = new Gem(w,c);
        }

        Arrays.sort(gems);

        int[] bags = new int[M];
        for (int i = 0; i < M; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < M; i++) {
            while (j < N && gems[j].weigh <= bags[i]) {
                pq.offer(gems[j++].cost);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}

class Gem implements Comparable<Gem>{
    int weigh;
    int cost;

    @Override
    public int compareTo(Gem g) {
        if (this.weigh == g.weigh)return g.cost - this.cost;
        return this.weigh - g.weigh;
    }

    public Gem(int weigh, int cost) {
        this.weigh = weigh;
        this.cost = cost;
    }
}
