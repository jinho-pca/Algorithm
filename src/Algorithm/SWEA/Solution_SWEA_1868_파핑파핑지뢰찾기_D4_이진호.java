package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1868_파핑파핑지뢰찾기_D4_이진호 {
    static int N, result;
    static char[][] map;
    static int[][] copy;
    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;
            map = new char[N][N];
            copy = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '*'){
                        copy[i][j] = -1;
                        visited[i][j] = true;
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                            if(map[nr][nc] == '*') cnt++;
                        }
                    }
                    copy[i][j] = cnt;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(copy[i][j] == 0 && !visited[i][j]){
                        result++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) result++;
                }
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static void dfs(int r, int c){
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(!visited[nr][nc] && copy[nr][nc] > 0){
                    visited[nr][nc] = true;
                }else if(!visited[nr][nc] && copy[nr][nc] == 0){
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    } // end of dfs
} // end of class