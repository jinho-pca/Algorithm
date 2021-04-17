package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2239_스도쿠_골드4_이진호 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0,0);
    } // end of main
    private static void dfs(int r, int c){
        // 행
        if(c == 9){
            dfs(r+1, 0);
            return;
        }
        // 열
        if(r == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
//                    System.out.print(map[i][j]);
                    sb.append(map[i][j]);
                }
//                System.out.println();
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        if(map[r][c] == 0){
            for (int i = 1; i <= 9; i++) {
                if(check(r, c, i)){
                    map[r][c] = i;
                    dfs(r, c+1);
                }
            }
            map[r][c] = 0;
            return;
        }
        dfs(r, c+1);
    }
    private static boolean check(int r, int c, int v){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if(map[r/3 * 3 + i][c/3 * 3 + j] == v) return false;

        }
        for (int i = 0; i < 9; i++)
            if(map[r][i] == v || map[i][c] == v) return false;

        return true;
    } // end of check
} // end of class
