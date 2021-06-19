package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2468_안전영역_실버1_이진호 {
    static int N, cnt, result = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());;
            }
        }

        for (int height = 0; height <=100; height++) {
            cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > height){
                        bfs(i, j, height);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.print(result);
    } // end of main
    private static void bfs(int r, int c, int height){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[] {r, c});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > height){
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    } // end of bfs
} // end of class
