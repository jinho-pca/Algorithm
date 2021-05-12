package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기_이진호 {
    static int N, W, H, result;
    static int[] line, brick;
    static int[][] map;
    static int[][] copy;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            line = new int[N];
            map = new int[H][W];
            visited = new boolean[H][W];
            q = new LinkedList<>();

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            perm(0);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main

    private static void perm(int cnt){
        if(cnt == N){ // 중복순열이 만들어지면
            int[][] copy = copyArray(map);
            int brickCnt = 0;

            for (int i = 0; i < N; i++) {
                // 방문배열생성
                visited = new boolean[H][W];
                // 벽돌깨기
                dazzle(copy, line[i]);
                // 정렬
                sort(copy);
            }
            brickCnt = countBrick(copy);
            // 벽돌수가 적다는 말은 그만큼 많이 깨버린 것이니 result 값 갱신
            result = Math.min(result, brickCnt);

            return;
        }

        for (int i = 0; i < W; i++) {
            line[cnt] = i;
            perm(cnt+1);
        }


    } // end of perm

    private static void sort(int[][] copy) {
        Queue<Integer> tmp;
        for (int i = 0; i < W; i++) {
            tmp = new LinkedList<>();
            // 밑에서부터 차례대로 큐에 담기
            for (int j = H-1; j >=0 ; j--) {
                if(copy[j][i] > 0){
                    tmp.offer(copy[j][i]);
                }
            }
            // 밑에서부터 정렬
            for (int j = H-1; j >= 0 ; j--) {
                if(!tmp.isEmpty()){
                    copy[j][i] = tmp.poll();
                }else{
                    copy[j][i] = 0;
                }
            }
        }
    } // end of sort

    private static void dazzle(int[][] copy, int loc) {
        // 중복순열결과로 떨어지는 위치는 골랐으니 떨어졌을 때 처음 충돌하는 구슬의 위치를 구한다.
        for (int i = 0; i < H; i++) {
            if(copy[i][loc] > 0){
                q.offer(new int[] {i, loc, copy[i][loc]}); // 벽돌하나를 표현하는 배열을 큐에 저장(행번호, 열번호, 벽돌값)
                break;
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < cur[2]; i++) {
                    int nr = cur[0] + dr[d] * i;
                    int nc = cur[1] + dc[d] * i;

                    if(nr >= 0 && nc >= 0 && nr < H && nc < W && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc, copy[nr][nc]});
                        copy[nr][nc] = 0;
                    }
                }
            }
        }
    } // end of dazzle

    private static int[][] copyArray(int[][] map) {
        int[][] tmp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    } // end of copyArray
    private static int countBrick(int[][] map){
        int tmp = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] > 0)
                    tmp++;
            }
        }
        return tmp;
    } // end of countBrick
} // end of class
