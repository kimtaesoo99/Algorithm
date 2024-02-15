import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	private static List<int[]> list;
	private static Country[][] countries;
	private static Country[] now;
	private static boolean[] can;

	public static void main(String[] args) {
		countries = new Country[4][6];
		can = new boolean[4];
		now = new Country[6];
		list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				list.add(new int[] { i, j });
			}
		}

		for (int t = 0; t < 4; t++) {
			for (int i = 0; i < 6; i++) {
				countries[t][i] = new Country(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		}

		for (int i = 0; i < 6; i++) {
			now[i] = new Country(0, 0, 0);
		}

		back(0);

		for (boolean c : can) {
			System.out.print((c ? 1 : 0) + " ");
		}
	}

	private static void back(int index) {
		if (index == 15) {
			for (int i = 0; i < 4; i++) {
				if (!can[i] && Arrays.equals(countries[i], now)) {
					can[i] = true;
				}
			}

			return;
		}

		int[] info = list.get(index);
		int first = info[0];
		int second = info[1];

		if (now[first].win < 5 && now[second].lose < 5) {
			now[first].win++;
			now[second].lose++;
			back(index + 1);
			now[first].win--;
			now[second].lose--;
		}

		if (now[first].draw < 5 && now[second].draw < 5) {
			now[first].draw++;
			now[second].draw++;
			back(index + 1);
			now[first].draw--;
			now[second].draw--;
		}

		if (now[first].lose < 5 && now[second].win < 5) {
			now[first].lose++;
			now[second].win++;
			back(index + 1);
			now[first].lose--;
			now[second].win--;
		}
	}
}

class Country {

	int win;
	int draw;
	int lose;

	public Country(int win, int draw, int lose) {
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Country country = (Country) o;
		return win == country.win && draw == country.draw && lose == country.lose;
	}

	@Override
	public int hashCode() {
		return Objects.hash(win, draw, lose);
	}
}