package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적녹색약_골드5 {
    static int N;
    static int[] result = new int[2];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited_normal;
    static boolean[][] visited_rg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited_normal = new boolean[N][N];
        visited_rg = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited_normal[i][j]) {
                    bfs_normal(i, j, map[i][j]);
                    result[0]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited_rg[i][j]) {
                    bfs_rg(i, j, map[i][j]);
                    result[1]++;
                }
            }
        }
        System.out.print(result[0] + " " + result[1]);
    } // end of main
    private static void bfs_normal(int r, int c, char pick) {
        visited_normal[r][c] = true;
        Queue<int[]> q_normal = new LinkedList<>();
        q_normal.offer(new int[] {r, c});

        while(!q_normal.isEmpty()) {
            int[] cur = q_normal.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited_normal[nr][nc] && map[nr][nc] == pick) {
                    visited_normal[nr][nc] = true;
                    q_normal.offer(new int[] {nr, nc});
                }
            }
        }
    }
    private static void bfs_rg(int r, int c, char pick) {
        visited_rg[r][c] = true;
        Queue<int[]> q_rg = new LinkedList<>();
        q_rg.offer(new int[] {r, c});

        while(!q_rg.isEmpty()) {
            int[] cur = q_rg.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited_rg[nr][nc]) {
                    if(pick == 'B') {
                        if(map[nr][nc] == pick) {
                            visited_rg[nr][nc] = true;
                            q_rg.offer(new int[] {nr, nc});
                        }
                    } else {
                        if(map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                            visited_rg[nr][nc] = true;
                            q_rg.offer(new int[] {nr ,nc});
                        }
                    }
                }
            }
        }
    }
} // end of class
