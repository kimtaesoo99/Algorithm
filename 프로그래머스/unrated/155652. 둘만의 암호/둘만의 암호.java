class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(String s, String skip, int index) {
        for (int i = 0; i < s.length(); i++){
            change(s.charAt(i), skip, index);
        }
        return sb.toString();
    }

    private void change(char word, String skip, int index){
        for (int i = 1; i <= index; i++){
            char next = (char)(word + 1);
            if (next > 'z'){
                next = 'a';
            }
            if (checkSkipWord(next,skip)){
                i--;
            }
            word = next;
        }
        sb.append(word);
    }

    private boolean checkSkipWord(char word, String skip){
        return skip.contains(String.valueOf(word));
    }
}
