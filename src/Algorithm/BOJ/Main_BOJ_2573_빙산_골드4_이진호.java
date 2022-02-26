package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2573_빙산_골드4_이진호 {
    static int N, M, cnt, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while((cnt = countArea()) < 2) {
            if(cnt == 0) {
                result = 0;
                break;
            }

            melt();
            result++;
        }
        System.out.print(result);
    } // end of main
    private static void melt() {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int melt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    if(!visited[nr][nc] && map[nr][nc] == 0) melt++;
                }
            }
            if(map[cur[0]][cur[1]] - melt < 0) map[cur[0]][cur[1]] = 0;
            else map[cur[0]][cur[1]] -= melt;
        }
    } // end of bfs
    private static void dfs(int r, int c, boolean[][] check) {
        check[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < M && !check[nr][nc] && map[nr][nc] != 0) dfs(nr, nc, check);
        }
    } // end of dfs
    private static int countArea() {
        boolean[][] check = new boolean[N][M];
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!check[i][j] && map[i][j] != 0) {
                    dfs(i, j, check);
                    area++;
                }
            }
        }
        return area;
    } // end of countArea
} // end of class
