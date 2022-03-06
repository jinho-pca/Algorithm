package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17135_캐슬디펜스_골드4_이진호_bruteForce {
    static int N, M, D, result;
    static int num;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] archer = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        copyMap = new int[N+1][M+1];
        Arrays.fill(map[N], Integer.MIN_VALUE);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }
        comb(0, 0);
        System.out.print(result);
    } // end of main
    private static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    } // end of init
    private static int distance (int sr, int sc, int er, int ec) {
        return Math.abs(sr - er) + Math.abs(sc - ec);
    } // end of distance
    private static void attack() {
        int res = 0;
        for (int n = 1; n <= N; n++) {
            visited = new boolean[N+1][M+1];
            for (int k = 0; k < 3; k++) {
                int tmp = archer[k]; // 궁수의 열
                int minD = Integer.MAX_VALUE; // 최소거리
                int minR = Integer.MAX_VALUE; // 최소거리의 행
                int minC = Integer.MAX_VALUE; // 최소거리의 열

                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        if(map[i][j] == 1) {
                            int dis = distance(i, j, N+1, tmp);
                            if(minD >= dis) {
                                if(minD > dis) {
                                    minD = dis;
                                    minR = i;
                                    minC = j;
                                } else {
                                    if(minC > j) {
                                        minR = i;
                                        minC = j;
                                    }
                                }
                            }
                        }
                    }
                }
                if(minD <= D) {
                    visited[minR][minC] = true;
                }
            }
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(visited[i][j]) {
                        map[i][j] = 0;
                        res++;
                    }
                }
            }
            // 성 바로 윗 줄을 0으로 초기화
            for (int i = 1; i <= M; i++) {
                map[N][i] = 0;
            }
            // i번째 줄을 i-1번째 줄로 초기화
            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = map[i-1][j];
                }
            }
        }
        result = Math.max(result, res);
    } // end of game
    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            init();
            attack();
            return;
        }
        for (int i = start; i < M; i++) {
            archer[cnt] = i;
            comb(cnt+1, i+1);
        }
    } // end of comb
} // end of class
