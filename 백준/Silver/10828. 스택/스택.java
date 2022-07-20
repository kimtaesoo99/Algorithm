import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack s= new Stack();
        int N = sc.nextInt();
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <N; i++){
        String str = sc.next();
        if(str.contains("push")) {
            s.push(sc.nextInt());
            count++;
        }
        if(str.contains("top")){
            if(s.empty()) sb.append(-1).append('\n');
            else sb.append(s.peek()).append('\n');
        }
        if(str.contains("pop")){
            if (s.empty()) sb.append(-1).append('\n');
            else {
                sb.append(s.peek()).append('\n');
                s.pop();
                count--;
            }
        }
        if(str.contains("size")) sb.append(count).append('\n');
        if(str.contains("empty")){
            if (s.empty()) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        }
        System.out.println(sb);
    }
}
