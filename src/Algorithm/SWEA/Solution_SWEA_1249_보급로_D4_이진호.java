package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1249_보급로_D4_이진호 {
    static int N;
    static char[][] map;
    static int[][] mem;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/D4_1249_보급로.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][];
            mem = new int[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                Arrays.fill(mem[i], Integer.MAX_VALUE / 2);
            }

            Queue<int[]> q = new LinkedList<>();
            // 출발 = 0,0
            q.offer(new int[] { 0, 0, 0 });
            mem[0][0] = 0;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();

                for (int k = 0; k < 4; k++) {
                    int r = tmp[0] + dr[k];
                    int c = tmp[1] + dc[k];
                    if (range(r, c)) {
                        int time = tmp[2] + Integer.parseInt("" + map[r][c]);
                        if (mem[r][c] > time) {
                            mem[r][c] = time;
                            q.offer(new int[] { r, c, mem[r][c] });
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(mem[N-1][N-1]).append("\n");
        } // end of tc
        System.out.println(sb);
    }
    private static boolean range(int r, int c) {
        if (0 <= r && r < N && 0 <= c && c < N)
            return true;
        return false;
    }
} // end of class
