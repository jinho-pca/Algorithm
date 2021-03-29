package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
121624KB	604ms
 */
public class Main_BOJ_7576_토마토_실버1_이진호 {
    static int N, M, cnt; // cnt : 0의 개수
    static int max = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    static Queue<int[]> q; // 익은 토마토 집합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[] {i, j});
                }else if(map[i][j] == 0){
                    cnt++;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && visited[nr][nc] == false){
                    visited[nr][nc] = true;
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    if(map[nr][nc] > max){
                        max = map[nr][nc];
                    }
                    cnt--;
                    q.offer(new int[] {nr ,nc});
                }
            }
        }

        if(cnt == 0){
            System.out.println(max - 1);
        }else{
            System.out.println(-1);
        }
    } // end of main
} // end of class
