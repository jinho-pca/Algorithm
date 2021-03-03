package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_골드4_이진호{
    static int R, C, max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[] visited;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayList<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[26];
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j) - 'A';
            }
        }
        visited[map[0][0]] = true;
        dfs(0,0, 1);
        System.out.print(max);
    } // end of main
    private static void dfs(int r, int c, int cnt){
        if(max < cnt) {
            max = cnt;
        }
        for (int i = 0; i < 4; i++){
            int nr, nc;
            visited[map[r][c]] = true;
            nr = r + dr[i];
            nc = c + dc[i];

            if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                if(visited[map[nr][nc]] == false){
                    visited[map[nr][nc]] = true;
                    dfs(nr,nc, cnt+1);
                    visited[map[nr][nc]] = false;
                }
            }
        }
    } // end of method dfs
} // end of class