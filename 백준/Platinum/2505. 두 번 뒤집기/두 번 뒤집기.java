import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (!front(arr)) {
            back(arr);
        }
    }

    private static boolean front(int[] origin) {
        int[] arr = origin.clone();
        int count = 0;
        int target = 1;
        while (target != N) {
            for (int i = target; i <= N; i++) {
                if (target == arr[target]) {
                    break;
                }
                if (arr[i] == target) {
                    count++;
                    reverse(arr, target, i);
                    sb1.append(target).append(" ").append(i).append("\n");
                }
            }
            target++;
        }

        if (count == 1) {
            System.out.println("1 1");
            System.out.println(sb1.toString());
            return true;
        } else if (count == 2) {
            System.out.println(sb1.toString());
            return true;
        } else {
            return false;
        }
    }

    private static void back(int[] origin) {
        int[] arr = origin.clone();
        int cnt = 0;
        int target = N;
        while (target != 1) {
            for (int i = target; i >= 1; i--) {
                if (target == arr[target]) {
                    break;
                }
                if (arr[i] == target) {
                    cnt++;
                    reverse(arr, i, target);
                    sb2.append(i).append(" ").append(target).append("\n");
                }
            }
            target--;
        }

        if (cnt == 1) {
            System.out.println("1 1");
            System.out.println(sb2.toString());
        } else if (cnt == 2) {
            System.out.println(sb2.toString());
        } else {
            System.out.println("1 1");
            System.out.println("1 1");
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        int n = (int) Math.ceil((end - start) / 2.0);
        for (int i = 0; i < n; i++) {
            int temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}
