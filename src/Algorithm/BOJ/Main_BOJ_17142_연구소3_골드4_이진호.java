package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17142_연구소3_골드4_이진호 {
    static int N, M, cnt, result = Integer.MAX_VALUE;
    static int[] numbers;
    static int[][] originMap, map;
    static boolean[][] visited;
    static ArrayList<Point> virusList = new ArrayList<>();
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        originMap = new int[N][N];
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int pick = Integer.parseInt(st.nextToken());
                originMap[i][j] = pick;
                if(pick == 0) cnt++;
                else if(pick == 2) virusList.add(new Point(i, j, 0));
            }
        }
        if(cnt == 0) {
            System.out.print(0);
            return;
        }
        comb(0, 0);
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    } // end of main
    private static int bfs() {
        int time = 0;
        int zeroCnt = cnt;
        visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            Point active = virusList.get(numbers[i]);
            visited[active.r][active.c] = true;
            q.offer(active);
        }
        while(!q.isEmpty()) {
            Point cur = q.poll();
            visited[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != 1) {
                    if(map[nr][nc] == 0) {
                        // 마지막탐색에서 비활성이 활성으로 바뀐다면
                        // 그 경우는 계산할 필요없는 시간이므로 0인부분이 전염되는것만 시간에 넣는다.
                        time = cur.time + 1;
                        zeroCnt--;
                    }
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, cur.time+1));
                }
            }
        }
        if(zeroCnt == 0) return time;
        return Integer.MAX_VALUE;
    } // end of bfs
    private static void comb(int cnt, int start) {
        if(cnt == M) {
            init();
            result = Math.min(result, bfs());
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            numbers[cnt] = i;
            comb(cnt+1, i+1);
        }
    } // end of comb
    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }
} // end of class
