package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4963_섬의개수_실버2_이진호 {
    static int w, h, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 좌상 좌 좌하 하 우하 우 우상
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            result = 0;
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        result++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(result).append("\n");
        } // end of while tc
        System.out.print(sb.toString());
    } // end of main
    private static void bfs(int r, int c) {
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
} // end of class
