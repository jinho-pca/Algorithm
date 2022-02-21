package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14442_벽부수고이동하기2_골드3_이진호 {
    static int N, M, K, result = -1;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int dis;
        int breakCnt;

        public Point(int r, int c, int dis, int breakCnt) {
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.breakCnt = breakCnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K+1];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        visited[r][c][0] = true;
        q.offer(new Point(0, 0, 1, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                result = cur.dis;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc][cur.breakCnt]) {
                    if(map[nr][nc] == 1) {
                        // 벽인 경우
                        if(cur.breakCnt < K) {
                            // 벽을 깰 수 있는 경우
                            if(visited[nr][nc][cur.breakCnt]) continue;
                            visited[nr][nc][cur.breakCnt] = true;
                            q.offer(new Point(nr, nc, cur.dis+1, cur.breakCnt+1));
                        }
                    } else {
                        // 빈칸인 경우
                        // 이미 왔던 경로 체크
                        visited[nr][nc][cur.breakCnt] = true;
                        q.offer(new Point(nr, nc, cur.dis+1, cur.breakCnt));
                    }
                }
            }
        }
    }
} // end of class
