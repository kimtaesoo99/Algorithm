import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        int[] distance = new int[n-1];
        for(int i = 0; i < n-1; i++){
            distance[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            cost[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < n-1; i++){
            if(minCost>cost[i])minCost = cost[i];
            sum += minCost*distance[i];
        }

        System.out.println(sum);
    }
}
