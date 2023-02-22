import java.util.*;
class Solution {
    static char[] w = {'A','E','I','O','U'};
    static List<String> results = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        findResult(0,"");
        return results.indexOf(word);
    }
    
    public void findResult(int index,String result){
        results.add(result);
        if(index == 5)return;
        for(int i = 0; i < 5; i++){
            findResult(index+1,result + w[i]);
        }
    }
}