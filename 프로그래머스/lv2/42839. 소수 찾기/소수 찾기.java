import java.util.HashSet;
import java.util.Set;

class Solution {
    char[] paper;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        paper = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            paper[i] = numbers.charAt(i);
        }
        bfs("", 0);
        return set.size();
    }

    public void bfs(String value, int index){
        if (!value.equals("")){
            int number = Integer.parseInt(value);
            if (isPrime(number)) set.add(number);
        }
        if (paper.length == index)return;
        for (int i =0; i< paper.length; i++){
            if (!visited[i]){
                visited[i] = true;
                bfs(value+paper[i],index+1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int number){
        if (number == 0 || number ==1)return false;
        for (int i = 2; i<= Math.sqrt(number); i++){
            if (number % i ==0)return false;
        }
        return true;
    }
}