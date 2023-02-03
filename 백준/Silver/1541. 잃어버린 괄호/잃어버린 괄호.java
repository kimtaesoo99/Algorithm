import java.util.*;

class Main{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] numbers = str.split("-");

        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i< numbers.length; i++){

            String[] num = numbers[i].split("[+]");

            int sum = 0;

            for(String s: num){
                sum +=Integer.parseInt(s);
            }

            if(result == Integer.MAX_VALUE){
                result =sum;
            }else result -=sum;
        }

        System.out.println(result);
	}
}