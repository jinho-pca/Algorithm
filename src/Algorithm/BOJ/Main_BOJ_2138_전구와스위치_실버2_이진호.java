package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2138_전구와스위치_실버2_이진호 {
    static int N;
    static int[] before;
    static int[] after;

    public static void main(String[] args) throws IOException {

        // 주어진 정보를 저장한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        before = new int[N];
        after = new int[N];

        // s0는 시작 전구를 변경하지 않고 시작
        // s1은 시작 전구를 변경하고 시작
        int[] s0 = new int[N];
        int[] s1 = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            before[i] = s.charAt(i) - '0';
            s0[i] = s.charAt(i) - '0';
            s1[i] = s.charAt(i) - '0';
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            after[i] = s.charAt(i) - '0';
        }

        // a0는 s0의 배열에서 switch를 누른 횟수 - 0으로 시작
        // a1은 s1의 배열에서 switch를 누른 횟수 - 1로 시작
        int a0 = 0;
        int a1 = 1;

        for (int i = 0; i < N; i++) {
            // 제일 첫 위치에서는 s1 배열의 경우 0번째와 1번째를 변경하고 시작한다.
            if (i == 0) {
                s1[i] = s1[i] ^ 1;
                s1[i + 1] = s1[i + 1] ^ 1;
            } else {
                // 현재 s0 배열의 비교 위치가 만들고자 하는 상태의 위치와 다른 상태라면
                if (s0[i - 1] != after[i - 1]) {
                    // 스위치를 누른다.
                    change(s0, i);

                    // 누른 횟수 +1
                    a0++;
                }

                // 마지막에 도달했는데 값이 다르다면 최대값으로 변경
                if (i == N - 1 && s0[i] != after[i]) a0 = Integer.MAX_VALUE;

                // 현재 s1 배열의 비교 위치가 만들고자 하는 상태의 위치와 다른 상태라면
                if (s1[i - 1] != after[i - 1]) {
                    // 스위치를 누른다.
                    change(s1, i);

                    // 누른 횟수 +1
                    a1++;
                }

                // 마지막에 도달했는데 값이 다르다면 최대값으로 변경
                if (i == N - 1 && s1[i] != after[i]) a1 = Integer.MAX_VALUE;
            }
        }

        // 둘 다 최대값이라면 변경이 불가능한 경우이므로 -1을 출력
        if (a0 == Integer.MAX_VALUE && a1 == Integer.MAX_VALUE) {
            System.out.println(-1);
            // 그 외에는 더 작은 값을 출력
        } else {
            System.out.println(Math.min(a0, a1));
        }
        br.close();
    }

    private static void change(int[] arr, int i) {
        // 마지막 부분이라면 자신 이후는 변환이 불가하다.
        if (i == N - 1) {
            arr[i - 1] = arr[i - 1] ^ 1;
            arr[i] = arr[i] ^ 1;
            // 그 외의 모든 경우에는 양 옆 또한 변환을 시켜야 한다.
        } else {
            arr[i - 1] = arr[i - 1] ^ 1;
            arr[i] = arr[i] ^ 1;
            arr[i + 1] = before[i + 1] ^ 1;
        }
    }
}