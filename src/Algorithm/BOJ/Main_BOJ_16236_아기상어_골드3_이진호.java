package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_16236_아기상어_골드3_이진호 {
    static int N, time, eatCnt, sharkSize = 2;
    static int closeR, closeC, dis; // 가장 가까운 물고기의 행, 열, 거리
    static int sharkR, sharkC;
    static int[][] map, check;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true) {
            init();

            bfs(sharkR, sharkC);

            if(closeR != Integer.MAX_VALUE && closeC != Integer.MAX_VALUE) {
                // 가장 가까운 물고기의 좌표가 변한 경우 -> 진행가능하다.
                time += check[closeR][closeC];
                eatCnt++;
                if(eatCnt == sharkSize) {
                    // 상어의 크기와 먹은 물고기의 수가 같은 경우 -> 상어의 크기가 증가한다.
                    sharkSize++;
                    eatCnt = 0;
                }
                // 먹고 난 후 물고기가 있던 자리를 빈칸으로 만들어준다.
                map[closeR][closeC] = 0;
                // 상어의 위치를 갱신한다.
                sharkR = closeR;
                sharkC = closeC;
            } else break;
        }
        System.out.print(time);
    } // end of main
    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        check[r][c] = 0;
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < N) { // 범위 체크
                    if(check[nr][nc] == -1 && map[nr][nc] <= sharkSize) { // 방문체크와 이동가능한지 체크
                        check[nr][nc] = check[cur[0]][cur[1]] + 1;
                        if(map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
                            // 물고기가 존재하고 크기가 상어보다 작은 경우 -> 먹을 수 있다.
                            if(dis > check[nr][nc]) {
                                // 상어로부터의 거리가 기존의 가장 가까운 물고기보다 더 가까운 경우 -> 가까운 물고기 정보 갱신
                                closeR = nr;
                                closeC = nc;
                                dis = check[nr][nc];
                            } else if(dis == check[nr][nc]) {
                                // 상어로부터의 거리가 기존의 가장 가까운 물고기와 같은 경우 -> 제일 위쪽 중에서도 제일 왼쪽 선택
                                if(closeR == nr) {
                                    // 둘 다 높이가 같을 경우
                                    if(closeC > nc) {
                                        // 기존보다 더 왼쪽인 경우 -> 갱신
                                        closeR = nr;
                                        closeC = nc;
                                    }
                                } else if(closeR > nr) {
                                    // 기존보다 더 위인 경우 -> 갱신
                                    closeR = nr;
                                    closeC = nc;
                                }
                            }
                        }
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
    } // end of bfs
    private static void init() {
        dis = Integer.MAX_VALUE;
        closeR = Integer.MAX_VALUE;
        closeC = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Arrays.fill(check[i], -1);
        }
    } // end of init
} // end of class