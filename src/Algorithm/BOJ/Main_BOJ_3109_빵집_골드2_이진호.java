package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집_골드2_이진호 {
	static boolean[][] map;
	static int R;
	static int C;
	static int cnt;
	static int nr;
	static int nc;
	static int[] dr = {-1,0,1}; // 우상 우 우하
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 1 ≤ R ≤ 10,000
		C = Integer.parseInt(st.nextToken()); // 5 ≤ C ≤ 500
		map = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if(s.charAt(j) == 'x') {
					map[i][j] = true;
				}
			}
		}
		for(int i = 0; i < R; i++) {
			dfs(i,0);
		}
		System.out.print(cnt);
		
	} // end of main
	public static boolean dfs(int sr, int sc) {
		for(int i = 0; i < 3; i++) {
			nr = sr + dr[i];
			nc = sc + 1;
			
			if(nr >= 0 && nr < R && map[nr][nc] == false) {
				if(nc == C-1) {
					cnt++;
					return true;
				}
				map[nr][nc] = true;
				if(dfs(nr,nc)) {
					return true;
				}
			}
		}
		
		return false;
	}
} // end of class
