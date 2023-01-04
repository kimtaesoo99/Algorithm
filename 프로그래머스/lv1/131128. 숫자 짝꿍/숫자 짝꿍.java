class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i>=0; i--){
            int originXLength = X.length();
            int originYLength = Y.length();
            int afterXLength = X.replace(String.valueOf(i),"").length();
            int afterYLength = Y.replace(String.valueOf(i),"").length();
            sb.append(String.valueOf(i)
                    .repeat(Math.min(originXLength-afterXLength,originYLength-afterYLength)));
        }
        String result = sb.toString();
        if (result.equals(""))return "-1";
        else if (result.charAt(0)=='0')return "0";
        return result;
    }
}