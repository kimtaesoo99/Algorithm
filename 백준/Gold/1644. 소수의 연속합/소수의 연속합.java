import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> List = new ArrayList<>();
        boolean[] notPrime = new boolean[4000000];
        notPrime[1] = true;
        for(int i = 2; i < 2000000; i++){
            for(int j = 2; i*j<4000000; j++){
                notPrime[j*i] = true;
            }
        }
        for(int i = 1; i < 4000000; i++){
            if(!notPrime[i])List.add(i);
        }

        int count = 0;
        int start = -1;
        int sum = 0;
        loop : for(int i = 0; i < List.size(); i++){
            sum+=List.get(i);
            if(sum>=n){
                while(sum>=n){
                    if(sum==n)count++;
                    start++;
                    sum-=List.get(start);
                    if(start>i)break loop;
                }
            }
        }
        System.out.println(count);
    }
}
