package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17135_캐슬디펜스_골드4_이진호_bfs {
    static int N, M, D, cnt, result;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] numbers = new int[3];
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cnt++;
            }
        }
        comb(0, 0);
        System.out.print(result);
    } // end of main
    private static int bfs() {
        // map 복사
        init();
        int killCnt = 0;
        int enemyCnt = cnt;
        while(enemyCnt > 0) { // 한행씩 내리는 루프
            boolean flag = false;
            ArrayList<int[]> killList = new ArrayList<>();
            for (int archer = 0; archer < 3; archer++) {
                visited = new boolean[N][M];
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {N, numbers[archer]});
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int i = 0; i < 3; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                            int diff = distance(nr, nc, N, numbers[archer]);
                            if(diff <= D) {
                                if(copyMap[nr][nc] == 1) {
                                    killList.add(new int[] {nr, nc});
                                    flag = true;
                                    break;
                                } else {
                                    visited[nr][nc] = true;
                                    q.offer(new int[] {nr ,nc});
                                }
                            }
                        }
                    }
                    if(flag) break;
                }
                if(flag) {
                    flag = false;
                    continue;
                }
            }
            for (int i = 0; i < killList.size(); i++) {
                int[] pick = killList.get(i);
                if(copyMap[pick[0]][pick[1]] == 1) {
                    killCnt++;
                    enemyCnt--;
                    copyMap[pick[0]][pick[1]] = 0;
                }
            }
            for (int i = 0; i < M; i++) {
                if(copyMap[N-1][i] == 1) enemyCnt--;
            }
            for (int i = N-1; i > 0; i--) {
                copyMap[i] = copyMap[i-1].clone();
            }
            Arrays.fill(copyMap[0], 0);
        }

        return killCnt;
    } // end of bfs
    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            result = Math.max(result, bfs());
            return;
        }
        for (int i = start; i < M; i++) {
            numbers[cnt] = i;
            comb(cnt+1, i+1);
        }
    } // end of comb
    private static void init() {
                for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    } // end of init
    private static int distance(int sr, int sc, int er, int ec) {
        return Math.abs(sr - er) + Math.abs(sc - ec);
    }
} // end of class