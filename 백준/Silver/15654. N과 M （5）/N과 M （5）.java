import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getResult(N,M,0);
        System.out.println(sb);
    }

    public static void getResult(int N, int M, int index){
        if (M==index){
            for (int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                result[index] = arr[i];
                getResult(N,M,index+1);
                visited[i] = false;
            }
        }
    }
}
