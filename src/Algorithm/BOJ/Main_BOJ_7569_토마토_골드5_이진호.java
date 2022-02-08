package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569_토마토_골드5_이진호 {
    static int N, M, H, cnt, max;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                     int pick = Integer.parseInt(st.nextToken());
                    map[i][j][h] = pick;
                    if(pick == 0) cnt++;
                    if(pick == 1) q.offer(new int[] {i, j, h});
                }
            }
        }
        if(cnt == 0) {
            System.out.print(0);
            return;
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]][cur[2]] = true;
            for (int i = 0; i < 6; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int nh = cur[2] + dh[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && nh >= 0 && nh < H && !visited[nr][nc][nh] && map[nr][nc][nh] == 0) {
                    visited[nr][nc][nh] = true;
                    q.offer(new int[] {nr, nc, nh});
                    map[nr][nc][nh] = map[cur[0]][cur[1]][cur[2]] + 1;
                    if(max < map[nr][nc][nh]) {
                        max = map[nr][nc][nh];
                    }
                    cnt--;
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
