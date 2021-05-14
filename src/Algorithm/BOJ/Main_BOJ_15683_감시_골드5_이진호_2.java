package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
지도 저장 int[][] map
1~5 : CCTV, 0 : 빈칸, 6 : 벽 => 60
DFS
사각지대 0의 크기를 구하고 최솟값 출력
사각지대는 0만 센다 (= 벽 사각지대가 아님, CCTV 사각지대 아님 +1 초기화를 해주자)

CCTV로 감시하는 영역을 원복이 가능하게 하기 위해서
표시할 때 +1, 원복할때는 -1 set(r, c, 방향배열, 값)
CCTV 위치를 따로 저장하자
CCTV 종류마다 방향, 개수가 다르다 => 배열
CCTV 5번은 항상 고정, 시작에서 저장해서 map 에 표시하고 진행하자
 */
public class Main_BOJ_15683_감시_골드5_이진호_2 {
    static int N, M, min;
    static int[][] map;
    static ArrayList<int[]> cctv;
    private static ArrayList<int[]> cctv5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctv = new ArrayList<>(); // cctv번호, r,c
        cctv5 = new ArrayList<>(); // cctv번호, r,c
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0, index = 0; j < M; j++, index +=2) {
                int tmp = map[i][j] = s.charAt(index) - '0';
                if(tmp == 0) continue;
                if(tmp == 6){
                    map[i][j] = 60; // map의 감시영역이면 +1 연산하다가 6이 될 수 있기 때문에 큰 값으로 변경
                    continue;
                }
                map[i][j] = 1; // CCTV 위치도 감시영역으로 표시
                if(tmp == 5) cctv5.add(new int[] {tmp, i, j}); // cctv 별도로 저장
                else cctv.add(new int[] {tmp, i, j}); // cctv 별도로 저장
            }
        }
        // CCTV5를 map에 표시하기
        int[] cctv5Dir = cctvDir[5][0];
        for (int i = 0; i < cctv5.size(); i++) {
            int[] tmp = cctv5.get(i);
            set(tmp[1], tmp[2], cctv5Dir, 1);
        }
        min = Integer.MAX_VALUE; // 사각지대(0)의 개수의 최솟값
        dfs(0); // 1~4번 cctv를 차례대로 진행
        System.out.print(min);
    } // end of main
    // CCTV 하나씩 방향을 정한 뒤 다음 CCTV로 탐색
    private static void dfs(int cctvNum){
        if(cctvNum == cctv.size()){
            int cnt = count0(); // 0의 개수 카운팅, 최솟값 갱신
            if(min > cnt) min = cnt;
            return;
        }
        int[] tmp = cctv.get(cctvNum); // {타입, r, c}
        int type = tmp[0];
        for (int i = 0; i < cctvDir[type].length; i++) {
            set(tmp[1], tmp[2], cctvDir[type][i], 1);
            dfs(cctvNum + 1);
            set(tmp[1], tmp[2], cctvDir[type][i], -1); // 원상복구
        }
    } // end of dfs
    // map 상의 사각지대(0)의 개수 카운팅해서 리턴
    private static int count0() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    } // end of count0

    private static int[][][] cctvDir = { // 상0, 우1, 하2, 좌3
            {}, // 0번 CCTV
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 2}, {1, 3}}, // 2번 CCTV
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV
            {{0, 1, 2, 3}} // 5번 CCTV
    };
    private static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    private static int[] dc = {0, 1, 0, -1}; // 상우하좌

    // (r, c) 좌표에 주어진 dir[] 방향으로 값을 저장, 벽60 or 배열 끝까지
    private static void set(int r, int c, int[] dir, int val){
        // dir = new int[] {0, 1, 2};
        for (int i = 0; i < dir.length; i++) {
            int tr = dr[dir[i]];
            int tc = dc[dir[i]];
            int nr = r + tr;
            int nc = c + tc;
            while(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 60){ // 배열범위체크, 벽체크
                map[nr][nc] += val;
                nr += tr;
                nc += tc;
            }
        }
    } // end of set
} // end of class
