package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7562_나이트의이동_실버2 {
    static int TC, N, cnt;
    static int[] start, end;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            cnt = 0;
            start = new int[2];
            end = new int[2];
            st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            bfs(start, end);
        } // end of for tc
        System.out.print(sb.toString());
    }// end of main
    private static void bfs(int[] start, int[] end) {
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == end[0] && cur[1] == end[1]) {
                sb.append(map[end[0]][end[1]]).append("\n");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    } // end of bfs
} // end of class
