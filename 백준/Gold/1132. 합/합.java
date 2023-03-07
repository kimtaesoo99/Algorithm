import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Alpha[] alphas = new Alpha[10];
        for (int i = 0; i < 10; i++) {
            alphas[i] = new Alpha();
        }

        for (int i = 0; i < n; i++){
            String str = sc.next();
            alphas[str.charAt(0)-'A'].num += Math.pow(10, str.length() -1);
            alphas[str.charAt(0)-'A'].first = true;
            for (int j = 1; j < str.length(); j++){
                alphas[str.charAt(j) - 'A'].num += Math.pow(10,str.length()-j-1);
            }
        }

        boolean[] used = new boolean[10];
        long sum = 0;

        Arrays.sort(alphas);



        for (int i = 0 ; i < 10; i++){
            if (alphas[i].first){
                for (int j = 1; j<=9; j++){
                    if (!used[j]){
                        used[j] = true;
                        sum += alphas[i].num * (long)j;
                        break;
                    }
                }
            }else {
                for (int j = 0; j<=9; j++){
                    if (!used[j]){
                        used[j] = true;
                        sum += alphas[i].num * (long)j;
                        break;
                    }
                }
            }
        }

        System.out.println(sum);

    }
}

class Alpha implements Comparable<Alpha>{
    long num = 0;
    boolean first = false;

    @Override
    public int compareTo(Alpha o) {
        if(num>o.num)return 1;
        if(num==o.num)return 0;
        else return -1;

    }
    public Alpha() {
    }
}
