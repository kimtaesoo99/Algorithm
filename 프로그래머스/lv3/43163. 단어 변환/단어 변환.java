class Solution {
    static int count = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited= new boolean[words.length];
        changeWord(begin,target,words,0);
        return count==Integer.MAX_VALUE?0:count;
    }
    
    public void changeWord(String begin, String target, String[] words, int c){
        if(begin.equals(target)){
            count = c;
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && canChange(begin,words[i])){
                visited[i] = true;
                changeWord(words[i],target,words,c+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canChange(String s1, String s2){
        int diffCount = 0;
            
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))diffCount++;
        }
        if(diffCount==1)return true;
        return false;
    }
}