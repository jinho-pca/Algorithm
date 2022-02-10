package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기_골드4_이진호_RE {
    static int N, M, result = -1;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int dis;
        boolean broken;

        public Point(int r, int c, int dis, boolean broken) {
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.broken = broken;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
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

        bfs(0, 0);

        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<Point> q  = new LinkedList<>();
        visited[r][c][0] = true;
        q.offer(new Point(r, c, 1, false));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.r == N-1 && cur.c == M-1) {
                result = cur.dis;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc][0]) {
                    if(map[nr][nc] == 1) { // 벽인 경우
                        if(!cur.broken) {
                            if(visited[nr][nc][1]) continue;
                            // 벽을 깨고 진행
                            visited[nr][nc][1] = true;
                            q.offer(new Point(nr, nc, cur.dis+1, true));
                        } else continue;
                    } else { // 빈칸인 경우 방문체크만 하고 진행
                        if(cur.broken) {
                            if(visited[nr][nc][1]) continue;
                            visited[nr][nc][1] = true;
                            q.offer(new Point(nr, nc, cur.dis+1, cur.broken));
                        } else {
                            if(visited[nr][nc][0]) continue;
                            visited[nr][nc][0] = true;
                            q.offer(new Point(nr, nc, cur.dis+1, cur.broken));
                        }
                    }
                }
            }
        }
    }
} // end of class