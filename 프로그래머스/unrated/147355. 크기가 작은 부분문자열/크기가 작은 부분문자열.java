
class Solution {
    public int solution(String t, String p) {
        int count = 0;
        for (int i = 0; i <= t.length() - p.length(); i++){
            if (compare(t.substring(i,i+p.length()), p))count++;
        }
        return count;
    }

    boolean compare(String a, String b){
        if (a.equals(b))return true;
        else {
            for (int i = 0; i < b.length(); i++){
                if (a.charAt(i) < b.charAt(i))return true;
                else if (a.charAt(i) > b.charAt(i))return false;
            }
        }
        return false;
    }
}