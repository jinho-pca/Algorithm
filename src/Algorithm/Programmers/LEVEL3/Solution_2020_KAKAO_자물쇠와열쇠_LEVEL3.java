package Algorithm.Programmers.LEVEL3;

import java.util.*;
public class Solution_2020_KAKAO_자물쇠와열쇠_LEVEL3 {
    static int L, N, M, cnt;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;
        L = N + 2*M -2;
        int[][] map = new int[L][L];

        // key 이동 시 영역이탈 방지를 위한 새로운 배열
        for (int i = M-1, r = 0; i < N+M-1; i++, r++) {
            for (int j = M-1, c = 0; j < N+M-1; j++, c++) {
                map[i][j] = lock[r][c];
                if(lock[r][c] == 0) cnt++;
            }
        }

        for (int i = 0; i < 4 && !answer; i++) { // 90도 회전 루프
            for (int j = 0; j < N+M-1 && !answer; j++) {
                for (int k = 0; k < N+M-1 && !answer; k++) {
                    int tmp = 0;
                    for (int l = 0; l < M && tmp <= cnt; l++) {
                        for (int m = 0; m < M && tmp <= cnt; m++) {
                            if (j + l < M - 1 || j + l > N+M-2 || k + m < M - 1 || k + m > N+M-2) continue;
                            else if(key[l][m] == 1){
                                if(map[j + l][k + m] == 0) tmp++;
                                else tmp = Integer.MAX_VALUE;
                            }
                        }
                    }
                    if(tmp != cnt) continue;
                    answer = true;
                }
            }
            key = turn(key);
        }
        return answer;
    }
    private static int[][] turn(int[][] key){
        int[][] res = new int[M][M];
        for (int i = 0, r = 0; i < M; i++, r++) {
            for (int j = M-1, c=0; j >= 0; j--, c++) {
                res[r][c] = key[j][i];
            }
        }
        return res;
    }
}
