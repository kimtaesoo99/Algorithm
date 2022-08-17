import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count =0;
        for (int i=0;i<8;i++){
            String a = br.readLine();
            for (int j=0;j<8; j++) {
                if (i%2==0) {
                    if (a.charAt(j) == 'F' && j % 2 == 0) count++;
                }
                else if (a.charAt(j) == 'F' && j % 2 != 0) count++;
            }
        }
        System.out.println(count);
    }
}