import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> scores = List.of("D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        for (int i = 0; i < 20; i++) {
            String object = sc.next();
            double point = sc.nextDouble();
            String score = sc.next();

            if (score.equals("P")) {
                continue;
            } else if (score.equals("F")) {
                
            } else {
                int index = scores.indexOf(score);
                double sco = index * 0.5 + 1;
                sum += sco * point;
            }
            count += (int) point;
        }

        System.out.println(sum / (double) count);
    }
}
