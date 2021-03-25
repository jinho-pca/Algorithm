package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3_실버3_이진호 {

	static int r, c, size, min, max, R, C, sr, sc;
	static int[][] map, temp;

	static int[] tx = { 0, 1, 0, -1 };
	static int[] ty = { -1, 0, 1, 0 };

	static int[] fx = { 1, 0, -1, 0 };
	static int[] fy = { 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		size = stoi(st.nextToken());

		init();

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			switch (stoi(st.nextToken())) {
			case 1: // 상하반전
				reverse(true);
				break;
			case 2: // 좌우반전
				reverse(false);
				break;
			case 3: // 오른쪽으로 회전
				rotation(true);
				break;
			case 4: // 왼쪽으로 회전
				rotation(false);
				break;
			case 5: // 시계방향
				clock(tx, ty);
				break;
			case 6: // 반시계방향
				clock(fx, fy);
				break;
			}
		}
		print();
		System.out.println(sb);
	}

	private static void reverse(boolean flag) {
		if (flag) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					temp[i][j] = map[r - i - 1][j];
				}
			}
		} else {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					temp[i][j] = map[i][c - j - 1];
				}
			}

		}
		copy();
	}

	private static void rotation(boolean flag) {
		if (flag) {
			R = 0;
			C = r - 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					calc(flag);
					temp[R++][C] = map[i][j];
				}
			}
		} else {
			R = c - 1;
			C = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					calc(flag);
					temp[R--][C] = map[i][j];
				}
			}
		}
		int tmp1 = r;
		int tmp2 = sr;
		r = c;
		sr = sc;
		c = tmp1;
		sc = tmp2;
		copy();
	}

	private static void calc(boolean flag) {
		if (flag) {
			if (R >= c) {
				R = 0;
				C--;
			}
		} else {
			if (R < 0) {
				R = c - 1;
				C++;
			}
		}
	}

	private static void clock(int[] dx, int[] dy) {
		for (int i = 0; i < sr; i++) {
			for (int j = 0; j < sc; j++) {
				temp[i][j] = map[i + dx[1] * sr][j + dy[1] * sc];
			}
		}
		for (int i = 0; i < sr; i++) {
			for (int j = sc; j < c; j++) {
				temp[i][j] = map[i + dx[0] * sr][j + dy[0] * sc];
			}
		}
		for (int i = sr; i < r; i++) {
			for (int j = sc; j < c; j++) {
				temp[i][j] = map[i + dx[3] * sr][j + dy[3] * sc];
			}
		}
		for (int i = sr; i < r; i++) {
			for (int j = 0; j < sc; j++) {
				temp[i][j] = map[i + dx[2] * sr][j + dy[2] * sc];
			}
		}
		copy();
	}

	private static void copy() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	private static void print() throws IOException {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
	}

	private static void init() {
		max = Math.max(r, c);
		map = new int[max][max];
		temp = new int[max][max];
		min = (Math.min(r, c)) >> 1;
		sr = r >> 1;
		sc = c >> 1;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}