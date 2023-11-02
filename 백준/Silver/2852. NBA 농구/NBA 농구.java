import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String team = sc.next();
            String time = sc.next();
            String[] timeSplit = time.split(":");
            int timeInt = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            q.offer(new int[]{(Integer.parseInt(team)), timeInt});
        }

        int firstTeamScore = 0;
        int secondTeamScore = 0;

        int firstWinTime = 0;
        int secondWinTime = 0;

        int nowTime = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (firstTeamScore > secondTeamScore) {
                firstWinTime += (poll[1] - nowTime);
            }
            if (firstTeamScore < secondTeamScore) {
                secondWinTime += (poll[1] - nowTime);
            }
            int team = poll[0];
            if (team == 1) {
                firstTeamScore++;
            } else {
                secondTeamScore++;
            }
            nowTime = poll[1];
        }
        if (firstTeamScore > secondTeamScore) {
            firstWinTime += (48 * 60 - nowTime);
        }
        if (firstTeamScore < secondTeamScore) {
            secondWinTime += (48 * 60 - nowTime);
        }

        System.out.println(getHour(firstWinTime) + ":" + getMinute(firstWinTime));
        System.out.println(getHour(secondWinTime) + ":" + getMinute(secondWinTime));
    }

    private static String getHour(int time) {
        int hour = time / 60;
        if (hour < 10) {
            return "0" + hour;
        }
        return hour + "";
    }

    private static String getMinute(int time) {
        int minute = time % 60;
        if (minute < 10) {
            return "0" + minute;
        }
        return minute + "";
    }
}
