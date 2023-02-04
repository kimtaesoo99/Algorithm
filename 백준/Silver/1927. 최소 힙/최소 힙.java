import java.util.*;


class Main{
	public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    PriorityQueue q = new PriorityQueue();
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();
    for(int i = 0; i < N; i++){
        int value = sc.nextInt();
        if(value==0 && q.isEmpty())sb.append(0).append("\n");
        else if(value==0 && !q.isEmpty())sb.append(q.poll()).append("\n");
        else q.offer(value);
    }
    System.out.println(sb);
}

}

