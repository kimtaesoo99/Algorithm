import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Ingredient> list = new ArrayList<>();
    static List<Integer> gaps = new ArrayList<>();
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];

        for (int i = 0; i < n; i++){
            list.add(new Ingredient(sc.nextInt(), sc.nextInt()));
        }

        dfs(0,1, 0,0);
        Collections.sort(gaps);
        System.out.println(gaps.get(0));
    }

    private static void dfs(int count, int sourSum, int bitterSum,int choose){
        if (choose>=1)gaps.add(Math.abs(sourSum - bitterSum));
        if (count == n)return;

        dfs(count+1, sourSum * list.get(count).sour, bitterSum + list.get(count).bitter,choose+1);
        dfs(count+1, sourSum , bitterSum,choose);

    }
}

class Ingredient{
    public int sour;
    public int bitter;

    public Ingredient(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }
}
