import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    private static int max;
    private static Food[] foods;
    private static int limitCalorie;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            limitCalorie = Integer.parseInt(st.nextToken());
            max = 0;

            foods = new Food[count];

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            findMax(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void findMax(int valueSum, int calorieSum, int pre) {
        if (calorieSum > limitCalorie) {
            return;
        }

        max = Math.max(max, valueSum);

        for (int i = pre; i < count; i++) {
            findMax(valueSum + foods[i].value, calorieSum + foods[i].calorie, i + 1);
        }
    }
}

class Food {
    int value;
    int calorie;

    public Food(int value, int calorie) {
        this.value = value;
        this.calorie = calorie;
    }
}