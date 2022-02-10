package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기_골드4_이진호 {
    static int N, M, result = -1;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point{
        int r;
        int c;
        int distance;
        int drill;

        public Point(int r, int c, int distance, int drill) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.drill = drill;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c, 1, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                result = cur.distance;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if(map[nr][nc] == 0) {
                        // 그냥 갈 수 있는 경우
                        if(visited[nr][nc][cur.drill]) continue;
                        visited[nr][nc][cur.drill] = true;
                        q.offer(new Point(nr, nc, cur.distance+1, cur.drill));
                    } else {
                        // 벽을 부서야 갈 수 있는 경우
                        // 벽을 부술 수 없거나, 이미 왔던 길일 경우 pass
                        if(cur.drill != 0 || visited[nr][nc][cur.drill+1]) continue;
                        visited[nr][nc][cur.drill+1] = true;
                        q.offer(new Point(nr, nc, cur.distance+1, cur.drill+1));
                    }
                }
            }
        }
    }
} // end of class
