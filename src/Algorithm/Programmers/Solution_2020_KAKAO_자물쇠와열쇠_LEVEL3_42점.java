package Algorithm.Programmers;

public class Solution_2020_KAKAO_자물쇠와열쇠_LEVEL3_42점 {
    static int L, N, M, cnt;
    public static void main(String[] args) {
        int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        boolean result = false;
        result = solution(key, lock);
        System.out.print(result);
    } // end of main
    private static boolean solution(int[][] key, int[][] lock){
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
    private static boolean check(int[][] key, int[][] map, int r, int c){
        for (int i = 0; i < M; i++) {
            int tmp = 0;
            for (int j = 0; j < M; j++) {
                if (r + i < M - 1 || r + i > L - M || c + j < M - 1 || c + j > L - M) continue;
                else if(key[i][j] == 1){
                    if(map[r + i][c + j] == 0){
                        tmp++;
                    }
                }
            }
            if(cnt <= tmp) return true;
        }
        return false;
    }
} // end of class
/*
key를 돌리면서 한칸씩 이동시켜서 lock 의 전체 칸이 채워지는지 확인하는 방법
1. for : key를 90도 회전 (4)
2. for : key를 가로로 한칸씩 이동 (N+2M-3번)
3. for : key를 세로로 한칸씩 이동 (N+2M-3번)
4. map 의 모든 칸이 1인지 확인 (400)
4 * 57 * 57 * 400 = 5,198,400 -> 시간 충분할 거라 판단
 */