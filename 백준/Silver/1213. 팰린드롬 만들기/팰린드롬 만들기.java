import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        //알파벳 카운트
        int[] alpha = new int[26];
        for(int i=0; i<line.length(); i++) {
            int idx = line.charAt(i)-'A';
            alpha[idx]++;
        }

        int odd =0;
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i]%2!=0) odd++;
        }
        String result ="";
        StringBuilder sb = new StringBuilder();
        if(odd>1) result += "I'm Sorry Hansoo";
        else {
            for(int i=0; i<alpha.length; i++) {
                for(int r=0; r<alpha[i]/2; r++) {
                    sb.append((char)(i+65));
                }
            }
            result += sb.toString();
            String end = sb.reverse().toString();
            sb = new StringBuilder();
            for(int i=0; i<alpha.length; i++) {
                if(alpha[i]%2==1) {
                    sb.append((char)(i+65));
                }
            }
            result +=sb.toString()+end;
        }
        System.out.println(result);
    }
}