class Solution {
    public int solution(int n) {
               String nCount = Integer.toBinaryString(n);
        int count =0;
        for (int i=0;i<nCount.length();i++){
            if (nCount.charAt(i)=='1')count++;
        }
        while (true){
            int resultCount=0;
            String result = Integer.toBinaryString(++n);
            for (int i=0;i<result.length();i++){
                if (result.charAt(i)=='1')resultCount++;
            }

            if (count==resultCount)return n;
        }

    }
}