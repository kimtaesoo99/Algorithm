import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static char[][] map;
	private static int n;
	private static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		map = new char[n][n];
		
		int count = 0;
		
		int[] one = new int[2];
		int[] two = new int[2];
		int[] three = new int[2];
		
		for(int i = 0; i < n ; i++) {
			String line = sc.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'B') {
					if(count == 0) {
						one = new int[] {i,j};
					}
					if(count == 1) {
						two = new int[] {i,j};
					}
					if(count == 2) {
						three = new int[] {i,j};
					}
					count++;
				}
			}
		}
		Train start = new Train(one, two, three,0);
		
		bfs(start);
		System.out.println(result);
	}

	private static void bfs(Train start) {
		Deque<Train> q = new ArrayDeque<>();
		q.offer(start);
		
		Map<Train, Integer> visited = new HashMap<>();
		visited.put(start, 1);
		
		while(!q.isEmpty()) {
			Train now = q.poll();
			
			int[] f = now.one;
			int[] t = now.two;
			int[] h = now.three;
			int d = now.depth;

			// todo 탈출
			if(map[f[0]][f[1]] == 'E' && map[t[0]][t[1]] == 'E' && map[h[0]][h[1]] == 'E') {
				result = d;
				break;
			}
			
			if(canUp(now)) {
				int[] moveF = new int[] {f[0] -1 , f[1]};
				int[] moveT = new int[] {t[0] -1 , t[1]};
				int[] moveH = new int[] {h[0] -1 , h[1]};
				
				Train move = new Train(moveF,moveT,moveH, d + 1);
				
				if(!visited.containsKey(move)) {
					visited.put(move, 1);
					q.offer(move);
				}
			}
			
			if(canDown(now)) {
				int[] moveF = new int[] {f[0] +1 , f[1]};
				int[] moveT = new int[] {t[0] +1 , t[1]};
				int[] moveH = new int[] {h[0] +1 , h[1]};
				
				Train move = new Train(moveF,moveT,moveH, d + 1);
				
				if(!visited.containsKey(move)) {
					visited.put(move, 1);
					q.offer(move);
				}
			}
			
			if(canLeft(now)) {
				int[] moveF = new int[] {f[0]  , f[1] - 1};
				int[] moveT = new int[] {t[0]  , t[1] - 1};
				int[] moveH = new int[] {h[0]  , h[1] - 1};
				
				Train move = new Train(moveF,moveT,moveH, d + 1);
				
				if(!visited.containsKey(move)) {
					visited.put(move, 1);
					q.offer(move);
				}
			}
			
			if(canRight(now)) {
				int[] moveF = new int[] {f[0]  , f[1] + 1};
				int[] moveT = new int[] {t[0]  , t[1] + 1};
				int[] moveH = new int[] {h[0]  , h[1] + 1};
				
				Train move = new Train(moveF,moveT,moveH, d + 1);
				
				if(!visited.containsKey(move)) {
					visited.put(move, 1);
					q.offer(move);
				}
			}
			
			if(canLotate(now)) {
				int[] moveF = f;
				int[] moveT = t;
				int[] moveH = h;
				
				if(f[0] == t[0]) { // 가로가 같음
					moveF = new int[] {t[0] - 1, t[1]};
					moveH = new int[] {t[0] + 1, t[1]};
				} else {
					moveF = new int[] {t[0], t[1] - 1};
					moveH = new int[] {t[0] , t[1] + 1};
				}
				
				
				Train move = new Train(moveF,moveT,moveH, d + 1);
				
				if(!visited.containsKey(move)) {
					visited.put(move, 1);
					q.offer(move);
				}
			}
		}
	}

	private static boolean canUp(Train now) {
		int[] f = now.one;
		int[] t = now.two;
		int[] h = now.three;
		
		boolean can = true;
		
		if(!inMap(f[0] - 1 , f[1]) || map[f[0] - 1][f[1]] == '1') {
			can = false;
		}
		if(!inMap(t[0] - 1 , t[1]) || map[t[0] - 1][t[1]] == '1') {
			can = false;
		}
		if(!inMap(h[0] - 1 , h[1]) || map[h[0] - 1][h[1]] == '1') {
			can = false;
		}
		
		return can;
	}
	
	private static boolean canDown(Train now) {
		int[] f = now.one;
		int[] t = now.two;
		int[] h = now.three;
		
		boolean can = true;
		
		if(!inMap(f[0] + 1 , f[1]) || map[f[0] + 1][f[1]] == '1') {
			can = false;
		}
		if(!inMap(t[0] + 1 , t[1]) || map[t[0] + 1][t[1]] == '1') {
			can = false;
		}
		if(!inMap(h[0] + 1 , h[1]) || map[h[0] + 1][h[1]] == '1') {
			can = false;
		}
		
		return can;
	}

	private static boolean canLeft(Train now) {
		int[] f = now.one;
		int[] t = now.two;
		int[] h = now.three;
		
		boolean can = true;
		
		if(!inMap(f[0] , f[1] - 1) || map[f[0] ][f[1] - 1] == '1') {
			can = false;
		}
		if(!inMap(t[0] , t[1] - 1) || map[t[0] ][t[1] - 1] == '1') {
			can = false;
		}
		if(!inMap(h[0]  , h[1] - 1) || map[h[0] ][h[1] - 1] == '1') {
			can = false;
		}
		
		return can;
	}

	private static boolean canRight(Train now) {
		int[] f = now.one;
		int[] t = now.two;
		int[] h = now.three;
		
		boolean can = true;
		
		if(!inMap(f[0] , f[1] + 1) || map[f[0] ][f[1] + 1] == '1') {
			can = false;
		}
		if(!inMap(t[0] , t[1] + 1) || map[t[0] ][t[1] + 1] == '1') {
			can = false;
		}
		if(!inMap(h[0]  , h[1] + 1) || map[h[0] ][h[1] + 1] == '1') {
			can = false;
		}
		
		return can;
	}
	
	private static boolean canLotate(Train now) {
		// 가로로 같은지
		int[] f = now.one;
		int[] t = now.two;
		
		if(f[0] == t[0]) {
			if(canUp(now) &&canDown(now)) {
				return true;
			} else {
				return false;
			}
		} else { // 세로로 같은지
			if(canLeft(now) &&canRight(now)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private static boolean inMap(int y, int x) {
		return 0 <= y && y<n && 0<= x && x < n;
	}
}

class Train {
	
	int[] one;
	int[] two;
	int[] three;
	int depth;
	
	public Train(int[] one, int[] two, int[] three, int depth) {
		this.one = new int[2];
		for(int i = 0; i < 2; i++) {
			this.one[i] = one[i];
		}
		this.two = new int[2];
		for(int i = 0; i < 2; i++) {
			this.two[i] = two[i];
		}
		this.three = new int[2];
		for(int i = 0; i < 2; i++) {
			this.three[i] = three[i];
		}
		this.depth = depth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(one);
		result = prime * result + Arrays.hashCode(three);
		result = prime * result + Arrays.hashCode(two);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (!Arrays.equals(one, other.one))
			return false;
		if (!Arrays.equals(three, other.three))
			return false;
		if (!Arrays.equals(two, other.two))
			return false;
		return true;
	}
}