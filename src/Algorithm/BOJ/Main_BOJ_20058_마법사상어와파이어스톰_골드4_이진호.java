package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_20058_마법사상어와파이어스톰_골드4_이진호 {
    static int N, M, Q, len, sum, cnt;
    static int[][] map;
    static boolean[][] visited;
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2, N);
        map = new int[len][len];
        visited = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            fireStorm(Integer.parseInt(st.nextToken()));
            check();
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum += map[i][j];
                if(!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        sb.append(sum).append("\n").append(cnt);
        System.out.print(sb.toString());
    } // end of main
    private static void fireStorm(int L) {
        M = (int) Math.pow(2, L);
        for (int r = 0; r < len; r+=M) {
            for (int c = 0; c < len; c+=M) {
                rotate(r, c);
            }
        }
        return;
    } // end of fireStorm
    private static void rotate(int r, int c) {
        int[][] tmp = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[r+M-1-j][c+i];
            }
        }
        for (int i = r; i < r+M; i++) {
            for (int j = c; j < c+M; j++) {
                map[i][j] = tmp[i-r][j-c];
            }
        }
    } // end of rotate
    private static void check() {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int iceCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                    if(map[nr][nc] > 0) iceCnt++;
                }
                if(iceCnt < 3) {
                    list.add(new Point(i, j));
                }
            }
        }
        for(Point p : list) {
            if(map[p.r][p.c] == 0) continue;
            map[p.r][p.c]--;
        }
        return;
    } // end of check
    private static void bfs(int r, int c) {
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Point(r, c));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc));
                count++;
            }
        }
        cnt = Math.max(cnt, count);
        return;
    } // end of bfs
} // end of class
