import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String,String> map = new HashMap<>();
        for(String[] d : db){   
            map.put(d[0],d[1]);    
        }
        boolean id = false;
        boolean pw = false;
        if(map.containsKey(id_pw[0])){
            id = true;
            if(map.get(id_pw[0]).equals(id_pw[1]))pw=true;
        }
        if(id && pw)return "login";
        else if(id &&!pw)return "wrong pw";
        return "fail";
    }
}