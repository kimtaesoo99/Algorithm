
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static boolean[] check = new boolean[10];
    static char[] arr;
    static ArrayList<String> list= new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        inequal("",0);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
    static void inequal(String str, int index){
        if (index==k+1){
            list.add(str);
            return;
        }
        for (int i=0;i<=9;i++){
            if (index==0|| (!check[i]&&compare(str.charAt(str.length()-1)-'0',i, arr[index-1]))){
                check[i] = true;
                inequal(str+i,index+1);
                check[i] =false;
            }
        }

    }
    static boolean compare(int a, int b,char c){
        if (c=='<')return a<b;
        else return a>b;
    }

}
