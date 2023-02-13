import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("IOI");

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N-1; i++){
            sb.append("OI");
        }
        String P = sb.toString();

        int M = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int count = 0;
        int j = 0;
        char pre =' ';
        for (int i = 0; i < M; i++){
            if (word.charAt(i)==P.charAt(j)){
                j++;
            }else {
                if (pre=='I') j = 1;
                else if (pre=='O') j = 0;
            }
            if (j==P.length()){
                count++;
                j-=2;
            }
            pre = word.charAt(i);
        }

        System.out.println(count);
    }
}
