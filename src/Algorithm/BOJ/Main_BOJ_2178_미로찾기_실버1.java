package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로찾기_실버1 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    } // end of main
    private static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1){
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = map[curR][curC] + 1;
                    if(nr == N-1 && nc == M-1){
                        return;
                    }
                }
            }
        }
    }
} // end of class
