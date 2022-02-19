package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BOJ_2665_미로만들기_골드4_이진호 {
    static int N, result;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int wall;

        public Point(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N][N*N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> {return o1.wall - o2.wall;});
        q.offer(new Point(r, c, 0));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == N-1 && cur.c == N-1) {
                result = cur.wall;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if(map[nr][nc] == 1 && !visited[nr][nc][cur.wall]) {
                        // 빈칸인 경우 전진
                        visited[nr][nc][cur.wall] = true;
                        q.offer(new Point(nr, nc, cur.wall));
                    } else if(map[nr][nc] == 0 && !visited[nr][nc][cur.wall+1]) {
                        // 벽인 경우 깨고 진행 -> 이미 min값이 나왔고 이미 깬 벽이 그 수보다 크면 그냥 패스
                        visited[nr][nc][cur.wall+1] = true;
                        q.offer(new Point(nr, nc, cur.wall+1));
                    }
                }
            }
        }
    } // end of bfs
} // end of class
