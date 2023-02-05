import java.util.*;

class Main{
    static int[] chess;
    static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        chess = new int[N];

        getResult(0);
        System.out.println(count);
    }

    public static void getResult(int y){
        if(y == chess.length){
            count++;
            return;
        }
        for(int i = 0; i< chess.length; i++){
            chess[y] = i;
            if(canSet(y)){
                getResult(y+1);
            }
        }
    }

    public static boolean canSet(int y){
        for(int i = 0; i < y; i++){
            if(chess[i] == chess[y])return false;
            else if(Math.abs(y - i) == Math.abs(chess[y]- chess[i]))return false;

        }
        return true;
    }
}