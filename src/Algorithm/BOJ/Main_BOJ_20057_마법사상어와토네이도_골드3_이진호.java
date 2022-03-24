package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20057_마법사상어와토네이도_골드3_이진호 {
    static int N, outAmount, delAmount, sand, result;
    static int[][] map;
    static Point tornado, alpha;
    static int[] dr = {0, 1, 0, -1}, dc = {-1, 0, 1, 0}; // 좌하우상
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        tornado = new Point(N/2, N/2);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int turn = 0; turn < 2*N-1; turn++) {
            move(turn);
        }
        System.out.print(result);
    } // end of main
    private static void move(int turn) {
        int dist = (turn+2) / 2; // 해당 턴에 이동할 거리
        int dir = turn % 4; // 해당 턴에 이동하는 방향
        if(dist == N) dist--; // 마지막 이동은 N-1번 이동한다.

        while(dist-- > 0) {
            boolean alphaOut = false;
            // y는 항상 영역의 안에 존재한다. 하지만 a는 영역밖일 수도 있다.
            Point y = new Point(tornado.r + dr[dir], tornado.c + dc[dir]); // y의 위치
            sand = map[y.r][y.c]; // 영향받는 모래의 양
            delAmount = 0; // 영역내의 다른칸에 뿌려진 모래의 양
            outAmount = 0; // 밖으로 나가는 모래의 양 초기화
            // 현재 토네이도는 x의 위치 -> y로 이동전에 1%영역 채우기
            spread(tornado, dir, 1, alphaOut); // 1% 채우기
            spread(y, dir, 7, alphaOut); // 7% 채우기

            // 10%, 5% 채우기 전에 a가 영역안에 존재하는지 확인
            alpha = new Point(y.r + dr[dir], y.c + dc[dir]); // a의 위치
            if(alpha.r < 0 || alpha.r >= N || alpha.c < 0 || alpha.c >= N) alphaOut = true;

            spread(alpha, dir, 10, alphaOut); // 10% 채우기
            spread(alpha, dir, 5, alphaOut);// 5% 채우기

            // 토네이도 이동
            tornado.r = y.r;
            tornado.c = y.c;
            // 이동된 토네이도 위치의 모래 지우기
            map[tornado.r][tornado.c] = 0;
            // a위치 모래 채우기 : sand에서 영역밖으로 나간 모래(outAmount)와 영역내 다른칸으로 뿌려진 모래(delAmount)를 뺀값을 채운다.
            if(!alphaOut) {
                map[alpha.r][alpha.c] += sand - (outAmount + delAmount);
            } else {
                result += sand - (outAmount + delAmount);
            }
            // 해당 턴에서 밖으로 나간 모래 result값에 갱신
            result += outAmount;
        } // end of while dist

    } // end of move
    private static void spread(Point cur, int dir, int ratio, boolean alphaOut) {
        int val = (sand*ratio) / 100;
        if(alphaOut) {
            outAmount += val;
            return;
        }
        if(ratio == 5) {
            // 5% 채우기
            int nr = cur.r + dr[dir];
            int nc = cur.c + dc[dir];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                // 영역밖으로 모래가 나간다.
                outAmount += val;
            } else {
                // 영역안에서 해당 비율만큼 모래가 쌓인다.
                map[nr][nc] += val;
                delAmount += val;
            }
            return;
        }
        // 현재 cur의 위치에서 dir방향 기준으로 좌측, 우측 채우기

        for(int i = 1; i < 4; i += 2) {
            int nr = cur.r + dr[(dir+i)%4];
            int nc = cur.c + dc[(dir+i)%4];
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                // 영역밖으로 모래가 나간다.
                outAmount += val;
            } else {
                // 영역안에서 해당 비율만큼 모래가 쌓인다.
                map[nr][nc] += val;
                delAmount += val;
            }
            if(ratio == 7) { // 2% 채우기 위해 같은 방향으로 한번 더 이동해서 채운다.
                int newVal = (sand*2) / 100;
                nr += dr[(dir+i)%4];
                nc += dc[(dir+i)%4];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    // 영역밖으로 모래가 나간다.
                    outAmount += newVal;
                } else {
                    map[nr][nc] += newVal;
                    delAmount += newVal;
                }
            }
        }

    } // end of spread
} // end of class
