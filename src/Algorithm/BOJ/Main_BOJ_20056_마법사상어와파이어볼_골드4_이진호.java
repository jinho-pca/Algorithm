package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_20056_마법사상어와파이어볼_골드4_이진호 {
    static int N, M, K, result;
    static HashSet<Ball>[][] map;
    static Queue<Ball> q = new LinkedList<>();
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static class Ball {
        int r;
        int c;
        int m;
        int s;
        int d;
        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new HashSet[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Ball ball = new Ball(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[ball.r][ball.c].add(ball);
            q.offer(ball);
        }

        for (int i = 0; i < K; i++) {
            move();
            check();
        }
        calc();
        System.out.print(result);
    } // end of main
    private static void move() {
        while(!q.isEmpty()) {
            Ball cur = q.poll();
            int nr = (cur.r + N + dr[cur.d] * (cur.s % N)) % N;
            int nc = (cur.c + N + dc[cur.d] * (cur.s % N)) % N;
            map[cur.r][cur.c].remove(cur);
            cur.r = nr;
            cur.c = nc;
            map[nr][nc].add(cur);
        }
    } // end of move
    private static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = map[i][j].size();
                if(cnt == 1) for(Ball ball : map[i][j]) q.offer(ball);
                if(cnt < 2) continue;
                int mSum = 0;
                int sSum = 0;
                int even = 0;
                int odd = 0;
                boolean flag = false;
                for(Ball ball : map[i][j]) {
                    mSum += ball.m;
                    sSum += ball.s;
                    if(ball.d % 2 == 0) even++;
                    else odd++;
                }
                mSum /= 5;
                map[i][j].clear();
                if(mSum == 0) continue;
                sSum /= cnt;
                if(even == cnt || odd == cnt) flag = true;
                int start = flag ? 0 : 1;
                for(; start < 8; start += 2) {
                    Ball nBall = new Ball(i, j, mSum, sSum, start);
                    q.offer(nBall);
                    map[i][j].add(nBall);
                }
            }
        }
    } // end of check
    private static void calc() {
        while(!q.isEmpty()) result += q.poll().m;
    }
} // end of class
