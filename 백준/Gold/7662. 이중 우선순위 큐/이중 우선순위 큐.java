import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        for (int i = 0; i < test_case; i++){
            int calculate = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> q = new TreeMap<>();
            for (int j = 0; j < calculate; j++){
                String[] option = br.readLine().split(" ");
                String c = option[0];
                int value = Integer.parseInt(option[1]);
                if (c.equals("I")){
                    q.put(value, q.getOrDefault(value, 0) + 1);
                }else {
                    if (q.isEmpty())continue;

                    int delete = value == 1 ? q.lastKey() : q.firstKey();

                    if (q.put(delete, q.get(delete)-1) == 1) {
                        q.remove(delete);
                    }
                }
            }
            if (q.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(q.lastKey()).append(" ").append(q.firstKey()).append("\n");

        }
        System.out.println(sb);
    }
}


