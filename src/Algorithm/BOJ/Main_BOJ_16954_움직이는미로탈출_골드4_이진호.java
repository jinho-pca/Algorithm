package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_16954_움직이는미로탈출_골드4_이진호 {
    static int N = 8, result;
    static ArrayList<Point> wallList = new ArrayList<Point>();
    static char[][] map = new char[N][N];
    static boolean[][] visited = new boolean[N][N];
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1, 0}, dc = {0, -1, 0, 1, 1, 1, 0, -1, -1};
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '#') wallList.add(new Point(i, j));
            }
        }
        if(wallList.size() != 0) bfs(7, 0);
        else result = 1;
        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        while(!q.isEmpty()) {
            int len = q.size();
            visited = new boolean[N][N];
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                // 이동할때만 해도 빈칸이었지만 벽이 떨어지면서 나가리
                if(map[cur.r][cur.c] == '#') continue;
                // 목적지 도착
                if(cur.r == 0 && cur.c == 7) {
                    result = 1;
                    return;
                }
                for (int j = 0; j < 9; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(visited[nr][nc] || map[nr][nc] == '#') continue;
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc));
                }
            }
            move();
        }
    } // end of bfs
    private static void move() {
        for (int i = wallList.size()-1; i >= 0; i--) {
            Point cur = wallList.get(i);
            int nr = cur.r + 1;
            int nc = cur.c;
            if(nr >= N) {
                map[cur.r][cur.c] = '.';
                wallList.remove(i);
                continue;
            }
            map[nr][nc] = '#';
            map[cur.r][cur.c] = '.';
            wallList.get(i).r = nr;
        }
        return;
    } // end of move
} // end of class
