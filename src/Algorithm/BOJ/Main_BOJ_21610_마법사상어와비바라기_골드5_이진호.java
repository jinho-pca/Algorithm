package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_21610_마법사상어와비바라기_골드5_이진호 {
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> cmd = new LinkedList<>();
    static Queue<Point> cloud = new LinkedList<>();
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1}, dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cmd.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 시작 스팟 큐에 담기
        cloud.offer(new Point(N-1, 0));
        cloud.offer(new Point(N-1, 1));
        cloud.offer(new Point(N-2, 0));
        cloud.offer(new Point(N-2, 1));

        // 시작
        magic();
        count();
        System.out.print(result);
    } // end of main
    private static void magic() {
        while(!cmd.isEmpty()) {
            // visited : 해당 턴에서 사라진 구름 체크용도 -> 턴마다 초기화
            visited = new boolean[N][N];
            int[] curCmd = cmd.poll();
            int dir = curCmd[0];
            int dist = curCmd[1];
            // 비구름은 이동 시 범위 밖의 값도 가능
            int disR = dist*dr[dir];
            int disC = dist*dc[dir];
            if(disR < 0) disR = (disR*-1) % N * -1;
            else disR %= N;
            if(disC < 0) disC = (disC*-1) % N * -1;
            else disC %= N;
            while(!cloud.isEmpty()) {
                Point cur = cloud.poll();
                int nr = (cur.r + disR + N) % N;
                int nc = (cur.c + disC + N) % N;
                map[nr][nc] ++;
                visited[nr][nc] = true;
            }
            copyWater();
            addCloud();
        }
    } // end of magic
    private static void copyWater() {
        int nr = 0, nc = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) {
                    int cnt = 0;
                    for (int k = 2; k <= 8; k+= 2) {
                        nr = i + dr[k];
                        nc = j + dc[k];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0) cnt++;
                    }
                    map[i][j] += cnt;
                }
            }
        }
    } // end of copyWater
    private static void addCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -=2;
                    cloud.offer(new Point(i, j));
                }
            }
        }
        return;
    } // end of addCloud
    private static void count() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0) result += map[i][j];
            }
        }
    } // end of count
} // end of class
