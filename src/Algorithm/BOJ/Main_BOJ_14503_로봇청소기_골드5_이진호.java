package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_골드5_이진호 {
    static int N, M, result;
    static int robotR, robotC, dir;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; // 북동남서
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        robotR = Integer.parseInt(st.nextToken());
        robotC = Integer.parseInt(st.nextToken());;
        dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(robotR, robotC, dir);
        System.out.print(result);
    } // end of main
    private static void clean(int r, int c, int d) {
        boolean flag = false;
        if(!visited[r][c]) {
            visited[r][c] = true;
            result++;
        }
        for (int i = 0; i < 4; i++) {
            d = next_dir(d);
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(map[nr][nc] == 0 && !visited[nr][nc]) {
                clean(nr, nc, d);
                flag = true;
                break;
            }
        }
        if(!flag) {
            int nr = r - dr[d];
            int nc = c - dc[d];

            if(map[nr][nc] == 0) clean(nr, nc, d);
        }
    } // end of clean
    private static int next_dir(int cur_dir) {
        return (cur_dir + 3) % 4;
    } // end of next_dir
} // end of class
