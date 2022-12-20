
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            int top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()){
                if (stack.peek()[0]<top){
                    stack.pop();
                }
                else {
                    sb.append(stack.peek()[1]).append(" ");
                    stack.push(new int[]{top,i+1});
                    break;
                }
            }
            if (stack.isEmpty()){
                sb.append("0").append(" ");
                stack.push(new int[]{top,i+1});
            }
        }
        System.out.println(sb);
    }
}


