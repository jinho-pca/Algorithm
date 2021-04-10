package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
13740 KB
116ms
 */
public class Main_BOJ_1012_유기농배추_실버2_이진호 {
    static int M, N, K, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이 : 열
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이 : 행
            K = Integer.parseInt(st.nextToken()); // 배추개수
            map = new int[N][M]; // 배추밭
            visited = new boolean[N][M]; // 방문체크배열

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] =1;
            }

            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        } // end of testCase
        System.out.println(sb);
    } // end of main
    private static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1 && visited[nr][nc] == false){
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    } // end of bfs
} // end of class
