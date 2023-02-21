class Solution {
    static boolean[] visited;
    static int count;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        changeWord(begin,target,words,0);
        
        return count;
    }
    
    public void changeWord(String begin, String target, String[] words,int index){
        if(begin.equals(target)){
            count = index;
            return;
        }
        
        for(int i = 0; i< words.length; i++){
            if(!visited[i] && canChange(begin, words[i])){
                visited[i] = true;
                changeWord(words[i], target, words,index+1);
                visited[i] = false;
            }
        }
    }
    public boolean canChange(String word, String word2){
        int diff = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != word2.charAt(i))diff++;
        }
        return diff==1;
    }
}