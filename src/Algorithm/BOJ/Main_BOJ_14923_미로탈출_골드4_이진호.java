package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14923_미로탈출_골드4_이진호 {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;
    static Point start, end;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int cnt;
        int dist;
        public Point(int r, int c, int cnt, int dist) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        st = new StringTokenizer(br.readLine(), " ");
        start = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0, 0);
        st = new StringTokenizer(br.readLine(), " ");
        end = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    } // end of main
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c][0] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == end.r && cur.c == end.c) {
                result = Math.min(result, cur.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(!isRange(nr, nc)) continue;
                if(map[nr][nc] == 0) {
                    // 빈칸인 경우 그냥 보낸다.
                    if(visited[nr][nc][cur.cnt]) continue;
                    visited[nr][nc][cur.cnt] = true;
                    q.offer(new Point(nr, nc, cur.cnt, cur.dist+1));
                } else {
                    // 벽인 경우 이미 벽을 깬 수를 확인
                    if(cur.cnt != 0) continue;
                    if(visited[nr][nc][1]) continue;
                    visited[nr][nc][1] = true;
                    q.offer(new Point(nr, nc, 1, cur.dist+1));
                }
            }
        }
    } // end of bfs
    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    } // end of isRange
} // end of class
