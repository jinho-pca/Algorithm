package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2589_보물섬_골드5_이진호 {
    static int R, C, result = Integer.MIN_VALUE;
    static char[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
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
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'L'){
                    visited = new boolean[R][C];
                    bfs(i, j);
                }
            }
        }
        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Point(r, c, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            result = Math.max(result, cur.dist);
            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(visited[nr][nc] || map[nr][nc] != 'L') continue;
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc, cur.dist + 1));
            }
        }
    } // end of bfs
} // end of class
