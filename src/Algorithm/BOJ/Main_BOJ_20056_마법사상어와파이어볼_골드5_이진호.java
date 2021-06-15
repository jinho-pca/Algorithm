package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_20056_마법사상어와파이어볼_골드5_이진호 {
    static class Ball{
        public int r; // 행
        public int c; // 열
        public int m; // 질량
        public int s; // 속력
        public int d; // 방향

        public Ball() {
        }

        public Ball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    } // end of ball
    static int N, M, K, result;
    static ArrayList<Ball> [][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Ball> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Ball ball = new Ball(r, c, m, s, d);
            map[r][c].add(ball);
            result += m;
        }
        for (int i = 0; i < K; i++) {
            shoot();
        }
        System.out.print(result);
    } // end of main
    private static void shoot(){
        // 이동해야할 파이어볼 리스트
        ArrayList<Ball> tmp = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j].size() != 0){ // 파이어볼이 한개이상 존재할 경우 이동해야 된다.
                    for (int k = 0; k < map[i][j].size(); k++) {
                        Ball b = map[i][j].get(k); // 이동전 파이어볼
                        int nr = i + dr[b.d]*b.s % N; // 이동할 좌표 행
                        int nc = j + dc[b.d]*b.s % N; // 이동할 좌표 열
                        // ex) 애초에 출발지가 첫번째 행인 경우, 위로 1칸이 나오게 되면 맨 아래칸으로 보내야 한다.
                        if(nr > N) nr %= N;
                        else if(nr < 1) nr = N - (Math.abs(nr) % N);
                        if(nc > N) nc %= N;
                        else if(nc < 1) nc = N - (Math.abs(nc) % N);

                        Ball bb = new Ball(nr, nc, b.m, b.s, b.d);
                        tmp.add(bb);
                        // 파이어볼 제거 (아직 이동한 결과 반영 안된 상태)
                        map[i][j].remove(k--);
                    }
                }
            }
        }

        // 이동결과 반영
        for (int i = 0; i < tmp.size(); i++) {
            Ball tmpBall = tmp.get(i);
            map[tmpBall.r][tmpBall.c].add(tmpBall);
        }

        // 질량 방향 결정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j].size() > 1){
                    int nm = 0;
                    int ns = 0;
                    int odd = 0;
                    int even = 0;
                    for (int k = 0; k < map[i][j].size(); k++) {
                        Ball tmpBall = map[i][j].get(k);
                        nm += tmpBall.m;
                        ns += tmpBall.s;
                        if(tmpBall.d % 2 == 0) even++;
                        else odd++;
                    }
                    // 총질량에서 합쳐질 파이어볼의 질량 빼기
                    result -= nm;
                    nm /= 5;
                    // 총질량에 4개로 나누어진 파이어볼의 질량 추가
                    result += nm * 4;
                    ns /= map[i][j].size();
                    map[i][j].clear();
                    if(nm != 0){
                        if(even == 0 || odd == 0){ // 방향이 모두 짝수거나 모두 홀수
                            map[i][j].add(new Ball(i, j, nm, ns, 0));
                            map[i][j].add(new Ball(i, j, nm, ns, 2));
                            map[i][j].add(new Ball(i, j, nm, ns, 4));
                            map[i][j].add(new Ball(i, j, nm, ns, 6));
                        }else{
                            map[i][j].add(new Ball(i, j, nm, ns, 1));
                            map[i][j].add(new Ball(i, j, nm, ns, 3));
                            map[i][j].add(new Ball(i, j, nm, ns, 5));
                            map[i][j].add(new Ball(i, j, nm, ns, 7));
                        }
                    }
                }
            }
        }
    } // end of shoot
} // end of class