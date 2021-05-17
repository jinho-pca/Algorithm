package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 매 시간마다 각 위치에서 A의 가능한 BC리스트를 얻어오고 B의 가능한 BC리스트를 얻어온 후 그 결과를 조합하는 방법
2. 매 시간마다 각 위치에서 모든 BC리스트를 가지고 가능한 모든 경우를 시도하는 방법
BC 리스트 : 최대 8개
사용자 : 2명
모든 상황을 다 만들어도 64개 => A : 1, B : 2 의 경우와 A : 2, B : 1 의 경우는 다른 경우이다. => 중복순열
제한시간 체크 : 시간 * BC의개수^2 = 100 * 8^2 = 6400
사용자가 2명이니까 재귀보다는 이중 for문 사용
2번 방법 코드
 */
public class Solution_SWEA_5644_무선충전 {
    static int M, bcCnt;
    static int[] pathA, pathB, playerA, playerB;
    static int[][] bc;
    static int dx[] = {0, 0, 1, 0, -1}; // 그대로 상 우 하 좌
    static int dy[] = {0, -1, 0, 1, 0}; // 그대로 상 우 하 좌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        playerA = new int[2]; // 사용자 A의 위치
        playerB = new int[2]; // 사용자 B의 위치

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            bcCnt = Integer.parseInt(st.nextToken());

            playerA[0] = playerA[1] = 1;
            playerB[0] = playerB[1] = 10;

            pathA = new int[M+1];
            pathB = new int[M+1];
            bc = new int[bcCnt][4];

            StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
            StringTokenizer stB = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= M; i++) { // i=0 값은 0으로 남아있다.(0 : 그대로)
                pathA[i] = Integer.parseInt(stA.nextToken());
                pathB[i] = Integer.parseInt(stB.nextToken());
            }

            for (int i = 0; i < bcCnt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bc[i][0] = Integer.parseInt(st.nextToken()); // x
                bc[i][1] = Integer.parseInt(st.nextToken()); // y
                bc[i][2] = Integer.parseInt(st.nextToken()); // 거리값
                bc[i][3] = Integer.parseInt(st.nextToken()); // 충전량
            }
            sb.append("#").append(testCase).append(" ").append(move()).append("\n");
        } // end of for testCase
        System.out.print(sb);
    } // end of main
    private static int move(){
        int totalSum = 0;
        // 매 시간 마다의 각 위치에서 두 플레이어의 최대 충전량을 계산하여 합산
        for (int t = 0; t <= M; t++) { // 초기 위치도 충전시도
            // 두 플레이어 궤적에 따라 이동
            playerA[0] += dx[pathA[t]];
            playerA[1] += dy[pathA[t]];
            playerB[0] += dx[pathB[t]];
            playerB[1] += dy[pathB[t]];

            // 현 위치에서의 최대 충전량 계산
            totalSum += getMaxCharge();
        }
        return totalSum;
    } // end of move
    private static int check(int a, int x, int y){
        return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
    } // end of check
    private static int getMaxCharge(){
        int max = 0;
        for (int a = 0; a < bcCnt; a++) { // 플레이어 A가 선택한 BC
            for (int b = 0; b < bcCnt; b++) { // 플레이어 B가 선택한 BC
                // 0,0 0,1 0,2 1,0 1,1 1,2 2,0 2,1 2,2
                int sum = 0;
                int amountA = check(a, playerA[0], playerA[1]);
                int amountB = check(b, playerB[0], playerB[1]);
                // 두 충전소가 다르면
                if(a != b) sum = amountA + amountB;
                else sum = Math.max(amountA, amountB);

                if(max < sum) max = sum;
            }
        }
        return max;
    }
} // end of class
