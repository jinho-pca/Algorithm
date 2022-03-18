package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_골드5_이진호_RE {
    static int M, N, cnt, result = -1;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) cnt++;
                else if(map[i][j] == 1) q.offer(new Point(i, j, 0));
            }
        }
        if(cnt == 0) {
            System.out.print(0);
        } else {
            bfs();
            System.out.print(cnt == 0 ? result : -1);
        }
    } // end of main
    private static void bfs() {
        while(!q.isEmpty()) {
            Point cur = q.poll();
            visited[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != -1) {
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.dist + 1));
                    result = Math.max(result, cur.dist+1);
                    if(map[nr][nc] == 0) {
                        map[nr][nc] = 1;
                        cnt--;
                    }
                }
            }
        }
    } // end of bfs
} // end of class
