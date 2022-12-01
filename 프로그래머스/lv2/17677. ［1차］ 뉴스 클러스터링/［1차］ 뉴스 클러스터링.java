

import java.util.ArrayList;
import java.util.List;

/**
 * 2글자씩 나누어서 list에 넣음 str1, str2각각
 */

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = setList1(str1);
        List<String> list2 = setList2(str2);
        if ((list1.size()+list2.size())==0) return 65536;
        return getResult(list1,list2);
    }

    private List<String> setList1(String str1) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (s.matches("^[a-zA-Z]*$")) {
                list.add(s);
            }
        }
        return list;
    }

    private List<String> setList2(String str2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if (s.matches("^[a-zA-Z]*$")) {
                list.add(s);
            }
        }
        return list;
    }

    private int getResult(List<String> list1 , List<String> list2){
        List<String>  intersection = new ArrayList<>();
        for (String s : list1){
            if (list2.contains(s)){
                list2.remove(s);
                intersection.add(s);
            }
        }
        return (int)((intersection.size()/(double)(list1.size()+list2.size()))*65536);
    }

}
