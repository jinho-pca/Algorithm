package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14499_주사위굴리기_골드4_이진호 {
    static int N, M, R, C, K;
    static int[][] map;
    static int[] dr = {0, 0, 0, -1, 1}, dc = {0, 1, -1, 0, 0}; // 0동서북남
    static Dice dice;
    static class Dice {
        int r;
        int c;
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;

        public Dice(int r, int c, int top, int bottom, int left, int right, int front, int back) {
            this.r = r;
            this.c = c;
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.front = front;
            this.back = back;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new Dice(R, C, 0, 0, 0, 0, 0, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            int top = move(cmd);
            if(top == -1) continue;
            else sb.append(top).append("\n");
        }
        System.out.print(sb.toString());
    } // end of main
    private static int move(int cmd) {
        int nr = dice.r + dr[cmd];
        int nc = dice.c + dc[cmd];
        if(nr < 0 || nr >= N || nc < 0 || nc >= M) return -1;
        int tmp = 0;
        dice.r = nr;
        dice.c = nc;
        switch(cmd) {
            case 1: // 동쪽이동
                tmp = dice.top;
                dice.top = dice.left;
                dice.left = dice.bottom;
                dice.bottom = dice.right;
                dice.right = tmp;
                break;
            case 2: // 서쪽이동
                tmp = dice.top;
                dice.top = dice.right;
                dice.right = dice.bottom;
                dice.bottom = dice.left;
                dice.left = tmp;
                break;
            case 3: // 북쪽이동
                tmp = dice.top;
                dice.top = dice.front;
                dice.front = dice.bottom;
                dice.bottom = dice.back;
                dice.back = tmp;
                break;
            case 4: // 남쪽이동
                tmp = dice.top;
                dice.top = dice.back;
                dice.back = dice.bottom;
                dice.bottom = dice.front;
                dice.front = tmp;
                break;
        }

        if(map[nr][nc] == 0) {
            map[nr][nc] = dice.bottom;
        } else {
            dice.bottom = map[nr][nc];
            map[nr][nc] = 0;
        }
        return dice.top;
    } // end of move
} // end of class
