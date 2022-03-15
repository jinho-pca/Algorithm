package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18111_마인크래프트_실버2_이진호 {
    static int N, M, B, time = Integer.MAX_VALUE, height, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                max = cur > max ? cur : max;
                min = cur < min ? cur : min;
            }
        }
        for (int value = max; value >= min; value--) {
            int t = 0;
            int cnt = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] < value) {
                        // 목표 층보다 낮은 경우 -> 인벤토리에서 꺼내서 쌓는다.
                        t += (value - map[i][j]);
                        cnt -= (value - map[i][j]);
                    } else if(map[i][j] > value) {
                        // 목표 층보다 높은 경우 -> 제거하고 인벤토리에 넣는다.
                        t += 2 * (map[i][j] - value);
                        cnt += (map[i][j] - value);
                    } else continue;
                }
            }
            // 인벤토리에 있는 벽보다 더 많이 세운 경우 패스
            if(cnt < 0) continue;

            // 시간 갱신
            if(t < time) {
                time = t;
                height = value;
            }
        }
        System.out.print(time + " " + height);
    } // end of main
} // end of class
