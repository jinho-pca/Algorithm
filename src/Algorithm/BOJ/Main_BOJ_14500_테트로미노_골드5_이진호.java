package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14500_테트로미노_골드5_이진호 {
    private static int[][] map;
    private static int N;
    private static int M;
    private static int max;
    private static int[] sumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+6][M+6];
        for (int i = 3; i < N+3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 3; j < M+3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int[] x : map){
//            for (int y : x){
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }

        for (int i = 3; i < N+3; i++) {
            for (int j = 3; j < M+3; j++) {
                calc(i,j);
            }
        }

        System.out.print(max);
    } // end of main
    private static void calc(int r, int c){
        sumArray = new int[19];
        sumArray[0] = map[r][c] + map[r][c+1] + map[r][c+2] + map[r][c+3]; // ㅡ
        sumArray[1] = map[r][c] + map[r+1][c] + map[r+2][c] + map[r+3][c]; // ㅣ
        sumArray[2] = map[r][c] + map[r][c+1] + map[r+1][c] + map[r+1][c+1]; // ㅁ
        sumArray[3] = map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+1]; // ㅜ
        sumArray[4] = map[r][c] + map[r][c+1] + map[r-1][c+1] + map[r+1][c+1]; // ㅓ
        sumArray[5] = map[r][c] + map[r][c+1] + map[r-1][c+1] + map[r][c+2]; // ㅗ
        sumArray[6] = map[r][c] + map[r][c+1] + map[r-1][c] + map[r+1][c]; // ㅏ
        sumArray[7] = map[r][c] + map[r+1][c] + map[r+2][c] + map[r+2][c+1]; // L
        sumArray[8] = map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c]; // r 가로긴거
        sumArray[9] = map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r+2][c+1]; // ㄱ 세로긴거
        sumArray[10] = map[r][c] + map[r][c+1] + map[r][c+2] + map[r-1][c+2]; // ㅢ 가로긴거
        sumArray[11] = map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+2][c+1]; // 왼쪽상단 시작 번개
        sumArray[12] = map[r][c] + map[r][c+1] + map[r-1][c+1] + map[r-1][c+2]; // S
        sumArray[13] = map[r][c] + map[r][c+1] + map[r-1][c+1] + map[r-2][c+1]; // ㅢ 세로긴거
        sumArray[14] = map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+1][c+2]; // ㄴ 가로긴거
        sumArray[15] = map[r][c] + map[r][c+1] + map[r+1][c] + map[r+2][c]; // r 세로긴거
        sumArray[16] = map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+2]; // ㄱ 가로긴거
        sumArray[17] = map[r][c] + map[r+1][c] + map[r][c+1] + map[r-1][c+1]; // 오른쪽상단 시작 번개
        sumArray[18] = map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r+1][c+2]; // ㄹ

        for (int i = 0; i < 19; i++) {
            max = max > sumArray[i] ? max : sumArray[i];
        }
    }
} // end of class
