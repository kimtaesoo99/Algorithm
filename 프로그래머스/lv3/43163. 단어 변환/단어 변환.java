
class Solution {
    boolean[] visited;
    int count = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        getWord(target,words,0,begin);
        return count;
    }
    void getWord(String target, String[] word,int index,String now){
        if (now.equals(target)){
            count = index;
            return;
        }
        for (int i = 0; i < word.length; i++){
            int notOverlapCount = 0;
            if (visited[i])continue;
            for (int j = 0; j <word[i].length(); j++){
                if (now.charAt(j) != word[i].charAt(j))notOverlapCount++;
                if (notOverlapCount>1)break;
            }
            if (notOverlapCount==1){
                visited[i] = true;
                getWord(target, word, index+1, word[i]);
                visited[i] = false;
            }
        }
    }
}