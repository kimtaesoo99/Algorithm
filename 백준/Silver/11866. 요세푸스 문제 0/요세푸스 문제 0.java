import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove(0)).append(">");

        System.out.println(sb);
    }
}
