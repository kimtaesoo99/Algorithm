class Solution {
    public int solution(int hp) {
        int[] ant = {5,3,1};
        int count = 0;
        for (int i : ant){
           count+= hp/i;
           hp = hp%i;
        }
        return count;
    }
}