package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트와링크_실버3_이진호 {
    static int N;
    static boolean[] visited;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(1, 0);
        System.out.println(min);
    }

    // 모든 팀의 조합 구하기
    static void comb(int start, int depth) {
        if (depth == N / 2) {
            min = Math.min(min, getAbilityDifference());
            return;
        }

        for (int i = start; i < N + 1; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                comb(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 팀의 능력치 차이를 구하기
    static int getAbilityDifference() {
        int sumStart = 0;
        int sumLink = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // true 면 스타트팀
                if (visited[i] && visited[j])
                    sumStart += arr[i][j];

                // false 면 링크팀
                if (visited[i] != true && visited[j] != true)
                    sumLink += arr[i][j];
            }
        }

        return Math.abs(sumStart - sumLink);
    }
}