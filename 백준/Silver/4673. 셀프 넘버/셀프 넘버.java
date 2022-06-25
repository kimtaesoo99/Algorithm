public class Main {

	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		
		for (int i = 1; i <= 10000; ++i) {
			int k = dn(i);
			if (k <= 10000) {
				check[k] = true;
			}
		}
		for (int i = 1; i < check.length; ++i) {
			if (!check[i]) {
				System.out.println(i);
			}
		}
	}
	private static int dn(int m) {
		int c = m;
		while(m > 0) {
			c += m % 10;
			m /= 10;
		}
		return c;
	}
}
