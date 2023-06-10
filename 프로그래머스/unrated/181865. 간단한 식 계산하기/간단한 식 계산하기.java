class Solution {
    public int solution(String binomial) {
        String[] info = binomial.split(" ");
        int a = Integer.parseInt(info[0]);
        String op = info[1];
        int b = Integer.parseInt(info[2]);
        if (op.equals("+")){
            return a+b;
        } else if (op.equals("-")) {
            return a-b;
        }
        return a*b;
    }
}