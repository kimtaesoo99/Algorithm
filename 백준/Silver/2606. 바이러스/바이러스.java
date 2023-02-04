import java.util.*;

class Main{
    static int count = -1;
    static boolean[] visited;
    static List<Integer>[] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int line = sc.nextInt();
        visited = new boolean[N+1];
        map = new ArrayList[N+1];

        for (int i = 1; i<N+1; i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a].add(b);
            map[b].add(a);
        }
        getCount(1);
        System.out.println(count);
    }

    public static void getCount(int start){
        visited[start] = true;
        count++;
        for (int i = 0; i<map[start].size(); i++){
            int y = map[start].get(i);
            if (!visited[y]){
                getCount(y);
            }
        }
    }
}

