import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] result = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (x, y) -> {
                    if (x.s == y.s)
                        return x.e - y.e;

                    return x.s - y.s;
                }
        );

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Node(num, s, e));
        }

        PriorityQueue<Room> room = new PriorityQueue<>(Comparator.comparingInt(x -> x.e));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (room.isEmpty()) {
                room.add(new Room(1, cur.e));
                result[cur.num] = 1;
            } else {
                if (room.peek().e <= cur.s) {
                    result[cur.num] = room.peek().num;
                    room.poll();
                    room.add(new Room(result[cur.num], cur.e));
                } else {
                    result[cur.num] = room.size() + 1;
                    room.add(new Room(result[cur.num], cur.e));
                }
            }
        }

        sb.append(room.size()).append("\n");

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}

class Room {
    int num;
    int e;

    Room(int num, int e) {
        this.num = num;
        this.e = e;
    }
}

class Node {
    int num;
    int s;
    int e;

    Node(int num, int s, int e) {
        this.num = num;
        this.s = s;
        this.e = e;
    }
}