import java.util.*;

public class Main {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	String[] arr = new String[N];
    	ArrayList<String> List = new ArrayList<>();
    	
    	for(int i=0; i<N;i++)arr[i]=sc.next();
    	
    	Arrays.sort(arr,new Comparator<String>() {
    		
    		public int compare(String s1, String s2){
    			if(s1.length()==s2.length())return s1.compareTo(s2);
    			else return s1.length() - s2.length();
    		}
    	});
    	
    	for(int i =0; i<arr.length; i++) {
    		if(!List.contains(arr[i]))List.add(arr[i]);
    	}
    	
    	for(String c : List)System.out.println(c);
    	
    }
}

