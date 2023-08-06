import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < numCount; i++) {
            int inputNum = sc.nextInt();
            numList.add(inputNum);
        }

        numList.sort(Integer::compareTo);

        boolean[] visited = new boolean[numCount];
        int prevNum = -2;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numCount; i++) {
            for (int j = 0; j < numCount; j++) {
                if (visited[j]) {
                    continue;
                }
                if (prevNum + 1 == numList.get(j)) {
                    continue;
                }

                boolean checkFlag = true;
                for (int k = 0; k < numCount; k++) {
                    if (visited[k]) {
                        continue;
                    }
                    if (k == j) {
                        continue;
                    }

                    int currentNum = numList.get(k);
                    int comparisonNum = numList.get(j);

                    if (currentNum == comparisonNum) {
                        continue;
                    }
                    if (currentNum != comparisonNum + 1) {
                        checkFlag = false;
                        break;
                    }
                }
                if (checkFlag) {
                    continue;
                }
                visited[j] = true;
                result.append(numList.get(j)).append(" ");
                prevNum = numList.get(j);
                break;
            }
        }

        for (int i = 0; i < numCount; i++) {
            if (!visited[i]) {
                result.append(numList.get(i)).append(" ");
            }
        }
        System.out.println(result);
    }
}
