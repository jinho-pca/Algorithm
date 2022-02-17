package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토_골드5_이진호 {
    static int N, M, cnt, max = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int pick = Integer.parseInt(st.nextToken());
                map[i][j] = pick;
                if(pick == 1) q.offer(new int[] {i, j});
                if(pick == 0) cnt++;
            }
        }
        if(q.isEmpty()) {
            System.out.print(-1);
            return;
        }
        bfs(q.poll());
        System.out.print(cnt == 0 ? max-1 : -1);
    } // end of main
    private static void bfs(int[] cur) {
        visited[cur[0]][cur[1]] = true;
        q.offer(cur);
        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != -1) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    if(map[nr][nc] != 0) {
                        map[nr][nc] = Math.min(map[nr][nc], map[current[0]][current[1]] + 1);
                    } else {
                        map[nr][nc] = map[current[0]][current[1]] + 1;
                        cnt--;
                    }
                    max = Math.max(max, map[nr][nc]);
                }
            }
        }
    } // end of bfs
} // end of class
