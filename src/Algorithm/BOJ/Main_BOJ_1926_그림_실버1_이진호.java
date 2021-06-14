package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1926_그림_실버1_이진호 {
    static int n, m, cnt, area;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.print(area);
    } // end of main
    private static void bfs(int r, int c){
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[] {r, c});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            res++;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
            area = area < res ? res : area;
        }
    } // end of bfs
} // end of class
