import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[first].add(next);
                inDegree[next]++;

                first = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int value = queue.poll();
            result.add(value);

            for (int link : list[value]) {
                inDegree[link]--;

                if (inDegree[link] == 0) {
                    queue.add(link);
                }
            }
        }

        if (result.size() != N) {
            System.out.println(0);
            return;
        }

        for (int singer : result) {
            System.out.println(singer);
        }
    }
}
