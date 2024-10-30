import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * X가 O의 수보다 1개 많거나 같아아함
 * <p>
 * X가 이길 경우 O의 수보다 반드시 1개 많아야함
 * <p>
 * O가 이길 경우 O의 수와 X의 수가 동일
 * <p>
 * 게임이 끝나지 않을경우 .은 없어야함
 * <p>
 * 둘다 이기는 경우는 없음
 */


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tic = br.readLine();
            if (tic.equals("end")) {
                break;
            }

            int xCount = getCount(tic, 'X');
            int oCount = getCount(tic, 'O');
            int datCount = getCount(tic, '.');

            boolean xWin = isWinner(tic, 'X');
            boolean oWin = isWinner(tic, 'O');

            if (xWin && oWin) {
                sb.append("invalid").append("\n");
                continue;
            }

            if (!(xCount == oCount || xCount == oCount + 1)) {
                sb.append("invalid").append("\n");
                continue;
            }

            if (xWin) {
                if (xCount == oCount + 1) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else if (oWin) {
                if (xCount == oCount) {
                    sb.append("valid").append("\n");
                } else {
                    sb.append("invalid").append("\n");
                }
            } else {
                if (datCount > 0) {
                    sb.append("invalid").append("\n");
                } else {
                    sb.append("valid").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int getCount(String tic, char c) {
        int count = 0;

        for (int i = 0; i < tic.length(); i++) {
            char now = tic.charAt(i);
            if (now == c) {
                count++;
            }
        }

        return count;
    }

    private static boolean isWinner(String tic, char c) {
        for (int i = 0; i < 9; i += 3) {
            if (tic.charAt(i) == c && tic.charAt(i + 1) == c && tic.charAt(i + 2) == c) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tic.charAt(i) == c && tic.charAt(i + 3) == c && tic.charAt(i + 6) == c) {
                return true;
            }
        }

        if (tic.charAt(0) == c && tic.charAt(4) == c && tic.charAt(8) == c) {
            return true;
        }

        if (tic.charAt(2) == c && tic.charAt(4) == c && tic.charAt(6) == c) {
            return true;
        }

        return false;
    }
}