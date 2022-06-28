import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String answer = "YES";
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '(')
                    stack.push(1);
                else if(stack.empty()) {
                    answer = "NO";
                    break;
                }
                else stack.pop();
            }

            if(!stack.empty()) answer = "NO";

            System.out.println(answer);
        }
    }
}

