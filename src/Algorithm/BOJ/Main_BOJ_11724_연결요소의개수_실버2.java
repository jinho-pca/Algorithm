package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11724_연결요소의개수_실버2 {
    static int N, M, result;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.print(result);
    } // end of main
    private static void dfs(int c) {
        if(visited[c]) return;

        visited[c] = true;
        for (int i = 1; i <= N; i++) {
            if(map[c][i] == 1) dfs(i);
        }
    }
} // end of class
