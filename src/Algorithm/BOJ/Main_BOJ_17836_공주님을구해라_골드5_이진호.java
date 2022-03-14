package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17836_공주님을구해라_골드5_이진호 {
    static int N, M, T, findRoute, result;
    static int[] knife;
    static int[][] map;
    static boolean[][] visited;
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
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) knife = new int[] {i, j};
            }
        }
        result = bfs();
        findRoute = find_bfs();
        if(result == 0 && findRoute == 0) {
            System.out.print("Fail");
        } else if(result == 0 && findRoute != 0) {
            System.out.print(findRoute > T ? "Fail" : findRoute);
        } else if(result != 0 && findRoute == 0) {
            System.out.print(result > T ? "Fail" : result);
        } else {
            int min = Math.min(result, findRoute);
            System.out.print(min > T ? "Fail" : min);
        }
    } // end of main
    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Point(0, 0, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.dist + 1));
                }
            }
        }
        return 0;
    } // end of bfs
    private static int find_bfs() {
        visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new Point(0, 0, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == knife[0] && cur.c == knife[1]) {
                return cur.dist + Math.abs(N-1 - cur.r) + Math.abs(M-1 - cur.c);
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.dist + 1));
                }
            }
        }
        return 0;
    } // end of find_bfs
} // end of class
