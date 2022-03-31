package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_9376_탈옥_플래티넘5_이진호 {
    static int T, R, C;
    static int[][] prisoner1, prisoner2, sanggeun;
    static char[][] map;
    static int sr1, sc1, sr2, sc2;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static class Point implements Comparable<Point> {
        int r;
        int c;
        int openCnt;
        public Point(int r, int c, int openCnt) {
            this.r = r;
            this.c = c;
            this.openCnt = openCnt;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.openCnt, o.openCnt);
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 바깥을 위해서 map을 더 크게 만든다
            map = new char[R + 2][C + 2];
            // map 가장자리는 빈공간으로 채운다
            Arrays.fill(map[0], '.');
            for (int i = 1; i <= R; i++) {
                map[i][0] = '.';
                map[i][C + 1] = '.';
            }
            Arrays.fill(map[R + 1], '.');

            // map 초기화
            int prisonerCnt = 0;
            for (int i = 1; i <= R; i++) {
                String s = br.readLine();
                for (int j = 1; j <= C; j++) {
                    map[i][j] = s.charAt(j - 1);
                    if (map[i][j] == '$') {
                        if (prisonerCnt == 0) {
                            sr1 = i;
                            sc1 = j;
                            prisonerCnt++;
                        } else if (prisonerCnt == 1) {
                            sr2 = i;
                            sc2 = j;
                        }
                    }
                }
            }

            // 3명의 사람에 대해서 bfs
            prisoner1 = bfs(sr1, sc1);
            prisoner2 = bfs(sr2, sc2);
            sanggeun = bfs(0, 0);

            // 칸에 있는 지나온 문의 갯수(열쇠사용횟수)를 다 더하고 최소값인 것을 정답으로 한다
            // 이 때 그 칸이 문일 경우 만나는 지점에서 3명이 동시에 문을 연 것이기 때문에 -2를 해준다.
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < R + 2; i++) {
                for (int j = 0; j < C + 2; j++) {
                    if(!visited[i][j]) continue;
                    if(map[i][j] == '*') continue;
                    int sum = sanggeun[i][j] + prisoner1[i][j] + prisoner2[i][j];

                    if (map[i][j] == '#') sum -= 2;
                    ans = Math.min(ans, sum);
                }
            }
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    } // end of main
    private static int[][] bfs(int sr, int sc) {
        int[][] openCnt = new int[R + 2][C + 2];
        visited = new boolean[R + 2][C + 2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        visited[sr][sc] = true;
        openCnt[sr][sc] = 0;
        pq.add(new Point(sr, sc, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (!isBorder(nr, nc) && !visited[nr][nc] && map[nr][nc] != '*') {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == '#') {
                        pq.add(new Point(nr, nc, p.openCnt + 1));
                        openCnt[nr][nc] = p.openCnt + 1;
                    } else {
                        pq.add(new Point(nr, nc, p.openCnt));
                        openCnt[nr][nc] = p.openCnt;
                    }
                }
            }
        }
        return openCnt;
    } // end of bfs
    private static boolean isBorder(int x, int y) {
        return (x < 0 || y < 0 || x > R + 1 || y > C + 1);
    } // end of isBorder
} // end of class