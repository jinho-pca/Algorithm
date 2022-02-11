package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main_BOJ_2583_영역구하기_실버1_이진호 {
    static int N, M, K, result;
    static ArrayList<Integer> areaList = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int depthR = er - sr;
            int depthC = ec - sc;
            for (int i = 0; i < depthR; i++) {
                for (int j = 0; j < depthC; j++) {
                    map[M-er + i][sc + j] = -1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    bfs(i, j);
                    result++;
                }
            }
        }
        sb.append(result).append("\n");
        Collections.sort(areaList);
        for(int x : areaList) {
            sb.append(x).append(" ");
        }
        System.out.print(sb.toString());
    }
    private static void bfs(int r, int c) {
        int area = 1;
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != -1) {
                    visited[nr][nc] = true;
                    map[nr][nc] = area++;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        areaList.add(area);
        return;
    }
}
