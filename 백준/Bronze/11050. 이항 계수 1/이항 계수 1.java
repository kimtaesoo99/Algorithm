import java.util.*;

public class Main {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int D=K;
    	int multi=1;
    	int divis=1;
    	for(int i =0; i<K;i++) {
    		multi*=N;
    		divis*=D;
    		N--;
    		D--;
    	}
    	System.out.println(multi/divis);
    }
}

