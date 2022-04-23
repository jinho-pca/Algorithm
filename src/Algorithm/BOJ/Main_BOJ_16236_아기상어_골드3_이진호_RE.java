package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_골드3_이진호_RE {
    static int N, cnt, result;
    static Point shark;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int size;
        int dist;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = 2;
            this.dist = 0;
        }
        public Point(int r, int c, int size, int dist) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    shark = new Point(i, j);
                    map[i][j] = 0;
                }
            }
        }
        while(bfs());
        System.out.print(result);
    } // end of main
    private static boolean bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            int diff = o1.dist - o2.dist;
            if(diff == 0) {
                int diff2 = o1.r - o2.r;
                if(diff2 == 0) return o1.c - o2.c;
                else return diff2;
            } else return diff;
        });
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[shark.r][shark.c] = true;
        q.offer(new Point(shark.r, shark.c, shark.size, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] > shark.size) continue;
                Point next = new Point(nr, nc, cur.size, cur.dist+1);
                visited[nr][nc] = true;
                q.offer(next);
                if(shark.size > map[nr][nc] && map[nr][nc] != 0) {
                    pq.offer(next);
                }
            }
        }
        if(pq.isEmpty()) return false;
        Point eat = pq.poll();
        if(++cnt == shark.size) {
            shark.size++;
            cnt = 0;
        }
        map[eat.r][eat.c] = 0;
        shark.r = eat.r;
        shark.c = eat.c;
        result += eat.dist;
        return true;
    } // end of move
} // end of class
