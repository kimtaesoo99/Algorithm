import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> list = new ArrayList<>();
    static char[] num;
    static int standard;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        standard = Integer.parseInt(str);
        num = str.toCharArray();
        visited = new boolean[num.length];

        bfs(0,"");
        Collections.sort(list);
        System.out.println(list.isEmpty()?"0":list.get(0));
    }

    private static void bfs(int index, String result){
        if (index == num.length){
            if (validation(result)){
                list.add(result);
            }
            return;
        }

        for (int i = 0; i < num.length; i++){
            if (!visited[i]){
                visited[i] = true;
                bfs(index+1, result + num[i]);
                visited[i] = false;
            }
        }

    }

    private static boolean validation(String num){
        return standard < Integer.parseInt(num);
    }
}

