package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_3055_탈출_골드4_이진호 {
    static class Point {
        int r;
        int c;
        int time;
        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point p = (Point) obj;
                return p.r == this.r && p.c == this.c;
            }
            return false;
        }
    }
    static int R, C, result = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> water = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char pick = s.charAt(j);
                map[i][j] = pick;
                if(pick == '*') water.offer(new Point(i, j, 0));
                if(pick == 'S') q.offer(new Point(i, j, 0));
            }
        }
        bfs();
        System.out.print(result == Integer.MAX_VALUE ? "KAKTUS" : result);
    } // end of main
    private static void bfs() {
        while(!q.isEmpty()) {
            int len = water.size();
            for (int i = 0; i < len; i++) {
                Point cur = water.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
                            map[nr][nc] = '*';
                            water.offer(new Point(nr, nc, 0));
                        }
                    }
                }
            }
            len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if(map[nr][nc] == 'D') {
                            result = Math.min(result, cur.time + 1);
                            return;
                        } else if(map[nr][nc] == '.') {
                            map[nr][nc] = 'S';
                            q.offer(new Point(nr, nc, cur.time+1));
                        }
                    }
                }
            }
        }
    }
} // end of class
