import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Conference> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Conference conference = new Conference(sc.nextInt(), sc.nextInt());
            list.add(conference);
        }
        list.sort(new Comparator<Conference>() {
            @Override
            public int compare(Conference o1, Conference o2) {
                if (o1.getEnd() != o2.getEnd()) {
                    return o1.getEnd() - o2.getEnd();
                } else {
                    return o1.getStart() - o2.getStart();
                }
            }
        });
        int count = 0;
        int endTime = -1;
        for (int i = 0; i < N; i++){
            if (list.get(i).getStart()>=endTime) {
                endTime = list.get(i).getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}

class Conference {
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
