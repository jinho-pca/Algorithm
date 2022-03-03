package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_6087_레이저통신_골드4_이진호 {
    static int W, H, result = Integer.MAX_VALUE;
    static char[][] map;
    static int[][] visited;
    static ArrayList<Point> spot = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int cnt;
        int dir;

        public Point(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'C') spot.add(new Point(i, j, 0, -1));
            }
        }
        bfs();
        System.out.print(result);
    } // end of main
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        Point start = spot.get(0);
        Point end = spot.get(1);
        q.offer(start);
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == end.r && cur.c == end.c) {
                result = Math.min(result, cur.cnt);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int nd = i;
                if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != '*') {
                    int nCnt = cur.cnt;
                    if(cur.dir != -1 && cur.dir != nd) {
                        // 처음이 아니고 현재방향에서 다음방향이 바뀌는 경우
                        nCnt++;
                    }
                    if(visited[nr][nc] == 0) {
                        visited[nr][nc] = nCnt;
                        q.offer(new Point(nr, nc, nCnt, nd));
                    } else if(visited[nr][nc] >= nCnt) {
                        visited[nr][nc] = nCnt;
                        q.offer(new Point(nr, nc, nCnt, nd));
                    }
                }
            }
        }
    } // end of bfs
} // end of class