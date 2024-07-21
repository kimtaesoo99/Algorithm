import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] infos = new Info[n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            infos[i] = new Info(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        Arrays.sort(infos);

        int total = 0;
        int preStart = infos[0].start;
        int preEnd = infos[0].end;

        for (int i = 1; i < infos.length; i++) {
            Info info = infos[i];
            if (info.start > preEnd) {
                total += preEnd - preStart;
                preStart = info.start;
            }
            preEnd = Math.max(info.end, preEnd);
        }

        total += preEnd - preStart;

        System.out.println(total);
    }
}

class Info implements Comparable<Info> {
    int start;
    int end;

    public Info(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Info o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}