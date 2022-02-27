package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4179_불_골드4_이진호 {
    static int R, C, time = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> fire = new LinkedList<>();
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
        int time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+2][C+2];
        visited = new boolean[R+2][C+2];
        for (int i = 0; i < R+2; i++) {
            Arrays.fill(map[i], '*');
        }
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j-1);
                if(map[i][j] == 'J') q.offer(new Point(i, j, 0));
                else if(map[i][j] == 'F') fire.offer(new Point(i, j, 0));
            }
        }
        bfs();
        System.out.print(time == Integer.MAX_VALUE ? "IMPOSSIBLE" : time);
    } // end of main
    private static void bfs() {
        while(!q.isEmpty()) {
            int len = fire.size();
            for (int i = 0; i < len; i++) {
                Point cur = fire.poll();
                visited[cur.r][cur.c] = true;
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr > 0 && nr < R+1 && nc > 0 && nc < C+1 && !visited[nr][nc] && map[nr][nc] != '#') {
                        map[nr][nc] = 'F';
                        visited[nr][nc] = true;
                        fire.offer(new Point(nr, nc, cur.time+1));
                    }
                }
            }
            len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                visited[cur.r][cur.c] = true;
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr > 0 && nr < R+1 && nc > 0 && nc < C+1 && !visited[nr][nc] && map[nr][nc] != '#') {
                        map[nr][nc] = 'J';
                        visited[nr][nc] = true;
                        q.offer(new Point(nr, nc, cur.time+1));
                    } else if(nr == 0 || nr == R+1 || nc == 0 || nc == C+1) {
                        if(map[nr][nc] == '*') {
                            time = cur.time+1;
                            return;
                        }
                    }
                }
            }
        }
    } // end of bfs
} // end of class
