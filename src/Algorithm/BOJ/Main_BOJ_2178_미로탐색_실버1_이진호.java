package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색_실버1_이진호 {
	static int N, M;
	static int cnt = 1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	
		bfs(0,0);
		System.out.print(map[N-1][M-1]);
		
	} // end of main
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});		
		
		while(!q.isEmpty()) {
			int[] next = q.poll();
			visited[r][c] = true;
			
			for(int i = 0; i < 4; i++) {
				int nr = next[0] + dr[i];
				int nc = next[1] + dc[i];
				
				if(nr >=0 && nc >= 0 && nr < N && nc < M) {
					if(map[nr][nc] == 1 && visited[nr][nc] == false) {
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
						map[nr][nc] = map[next[0]][next[1]] + 1;
					}
				}
			}
		}
	} // end of method bfs
	
} // end of class
