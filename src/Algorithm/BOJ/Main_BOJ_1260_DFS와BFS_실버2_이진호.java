package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS_실버2_이진호 {
	static int N, M, V;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}
 
	static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visited[V] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for (int i = 1; i <= N; i++) {
				if (map[x][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	static void dfs(int V) {
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(V);
		visited[V] = true;
		System.out.print(V + " ");

		for (int i = 1; i <= N; i++) {
			if (map[V][i] == 1 && visited[i] == false) {
//				stack.push(i);
				visited[i] = true;
				dfs(i);
			}
		}

	}
}
