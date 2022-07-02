import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	HashSet<String> setA = new HashSet<>();
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	for(int i =0;i<N;i++) {
    		setA.add(sc.next());
    	}    	
    	HashSet<String> setB = new HashSet<>();
    	for(int i =0;i<M;i++) {
    		setB.add(sc.next());
    	}
    	
    	int countA=0, countB=0;
    	Iterator<String> it = setA.iterator();
    	while(it.hasNext()) {
    		if(!setB.contains(it.next()))
    			countA++;
    	}
    	Iterator<String> it2 = setB.iterator();
    	while(it2.hasNext()) {
    		if(!setA.contains(it2.next()))
    			countB++;
    	}
    	System.out.println(countA+countB);
    }

}
