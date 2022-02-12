package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스_실버3_이진호_DFS_RE {
    static int N, M, result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " " );
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }
        dfs(1);
        System.out.print(result);
    }
    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && map[start][i] == 1) {
                result++;
                dfs(i);
            }
        }
    }
}
/*
start : 1 i : 2
start : 2 i : 3
start : 2 i : 5
start : 5 i : 6
총 4개의 경우가 나온다.
 */