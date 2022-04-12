package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_23288_주사위굴리기2_골드3_이진호 {
    static int N, M, K, result;
    static Dice dice = new Dice(0, 0, 0, 1, 6, 4, 3, 5, 2);
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 동남서북
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class Dice {
        int r;
        int c;
        int dir;
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;
        public Dice(int r, int c, int dir, int top, int bottom, int left, int right, int front, int back) {
            this.r = r;
            this.c = c;
            this.dir = dir;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int turn = 0; turn < K; turn++) {
            tumble();
        } // end of turn
        System.out.print(result);
    } // end of main
    private static void tumble() {
        int nr = dice.r + dr[dice.dir];
        int nc = dice.c + dc[dice.dir];
        if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
            // 해당 방향으로 이동하지 못하는 경우 -> 방햔 전환
            dice.dir = (dice.dir + 2) % 4;
            nr = dice.r + dr[dice.dir];
            nc = dice.c + dc[dice.dir];
        }
        // 주사위 좌표 갱신
        dice.r = nr;
        dice.c = nc;
        // 동서남북에 따라 주사위에 적힌 수 갱신
        updateDice();
        // 점수계산
        updateScore();
        // 방향전환
        updateDirection();
        return;
    } // end of tumble
    private static void updateDirection() {
        int diceCost = dice.bottom;
        int mapCost = map[dice.r][dice.c];
        if(diceCost > mapCost) {
            dice.dir = (dice.dir+1) % 4;
        } else if (diceCost < mapCost) {
            dice.dir = (dice.dir+3) % 4;
        }
        return;
    } // end of updateDirection
    private static void updateScore() {
        int cnt = 1;
        int mapCost = map[dice.r][dice.c];
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[dice.r][dice.c] = true;
        q.offer(new Point(dice.r, dice.c));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] != mapCost) continue;
                visited[nr][nc] = true;
                q.offer(new Point(nr, nc));
                cnt++;
            }
        }
        result += mapCost * cnt;
        return;
    } // end of updateScore
    private static void updateDice() {
        int tmp = -1;
        switch (dice.dir) {
            case 0: // 동
                tmp = dice.right;
                dice.right = dice.top;
                dice.top = dice.left;
                dice.left = dice.bottom;
                dice.bottom = tmp;
                break;
            case 1: // 남
                tmp = dice.front;
                dice.front = dice.top;
                dice.top = dice.back;
                dice.back = dice.bottom;
                dice.bottom = tmp;
                break;
            case 2: // 서
                tmp = dice.left;
                dice.left = dice.top;
                dice.top = dice.right;
                dice.right = dice.bottom;
                dice.bottom = tmp;
                break;
            case 3: // 북
                tmp = dice.back;
                dice.back = dice.top;
                dice.top = dice.front;
                dice.front = dice.bottom;
                dice.bottom = tmp;
                break;
        }
        return;
    } // end of updateDice
} // end of class
