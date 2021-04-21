package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_15683_감시_골드5_이진호 {
    static class cctv{
        int r;
        int c;
        int dir;

        public cctv(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    static int N, M, cnt;
    private static int[][] map;
    static ArrayList<cctv> list = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    static int[][][] dir = {
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 3}, {3, 1}, {1, 2}, {2, 0}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    list.add(new cctv(i, j, map[i][j]-1));
                }
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        if(!list.isEmpty()){
            dfs(0);
        }
        System.out.println(cnt);
    } // end of main
    private static void dfs(int start){
        if(start == list.size()){
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0){
                        tmp++;
                    }
                }
            }
            cnt = cnt > tmp ? tmp : cnt;
            return;
        }
        
        int type = list.get(start).dir;
        int[][] tmp = new int[N][M];
        copy(map, tmp);
        for (int i = 0; i < dir[type].length; i++) {
            for (int j = 0; j < dir[type][i].length; j++) {
                cctv cc = list.get(start);
                int nr = cc.r;
                int nc = cc.c;
                do {
                    map[nr][nc] = -1;
                    nr += dr[dir[type][i][j]];
                    nc += dc[dir[type][i][j]];
                } while (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != 6);
            }
            dfs(start+1);
            copy(tmp, map);
        }
    } // end of dfs
    private static void copy(int[][] from, int[][] to){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                to[i][j] = from[i][j];
            }
        }
    }
} // end of class
