import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int y = 0;
        int x = 0;
        for (int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            int nextY = y;
            int nextX = x;
            String path = "";
            if (c=='U'){ //현재 + 이동
                nextY++;
                path =""+ x+y+nextX+nextY;
            } else if (c=='D') {//이동 + 현재
                nextY--;
                path =""+ nextX+nextY+x+y;
            } else if (c=='R') {
                nextX++;
                path =""+ x+y+nextX+nextY;
            }else {
                nextX--;
                path = ""+nextX+nextY+x+y;
            }

            if (-5 > nextX || -5 > nextY || nextX > 5 || nextY > 5)continue;

            set.add(path);
            y = nextY;
            x = nextX;
        }
        return set.size();
    }
}