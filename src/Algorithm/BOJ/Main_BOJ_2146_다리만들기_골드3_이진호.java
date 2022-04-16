package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2146_다리만들기_골드3_이진호 {
    static int N, cnt, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    findIsland(i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) continue;
                init();
                int dist = makeBridge(i, j);
                if(dist == -1) continue;
                result = result < dist ? result : dist;
            }
        }
        System.out.print(result);
    } // end of main
    private static int makeBridge(int r, int c) {
        int dist = -1;
        int startNumber = map[r][c];
        visited[r][c] = true;
        q.offer(new Point(r, c));
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                if(map[cur.r][cur.c] != 0 && map[cur.r][cur.c] != startNumber) {
                    return dist;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(visited[nr][nc] || map[nr][nc] == startNumber) continue;
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc));
                }
            }
            dist++;
        }
        return -1;
    } // end of makeBridge
    private static void init() {
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
        q.clear();
        return;
    } // end of init
    private static void findIsland(int r, int c) {
        visited[r][c] = true;
        map[r][c] = cnt;
        q.offer(new Point(r, c));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] != 1) continue;
                visited[nr][nc] = true;
                map[nr][nc] = cnt;
                q.offer(new Point(nr, nc));
            }
        }
    } // end of findIsland
} // end of class
