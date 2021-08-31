package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1520_내리막길_골드4_이진호 {
    static int N, M;
    static int[][] map, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.print(dfs(0, 0));
    } // end of main
    private static int dfs(int r, int c){
        // 도착한 경우 추가탐색 필요없다.
        if(r == N-1 && c == M-1) return 1;
        // -1이 아닌 경우는 이미 방문했다.
        if(dp[r][c] != -1) return dp[r][c];
        else{
            dp[r][c] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(map[r][c] > map[nr][nc]) dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    } // end of dfs
} // end of class

/*
일반적인 dfs 문제로 해결하려고 했지만 시간초과
각 지점에서 4가지 경우가 존재하는데 지점의 최대개수는 25,000 이므로
최악의 경우 4^(25,000)이미 때문에 시간초과가 당연하다.
내리막을 찾는 방법은 결국 오르막을 찾는 방법과 같지만 시간적 이득은 볼 수 없다.
이런 경우 시간을 줄일 수 있는 방법은 중복되는 경우를 제거하는 것이다.
중복이 발생하는 경우를 생각해보면 갈라졌다 같은 지점으로 돌아오는 경우이다.
테스트케이스에서의 예시는 20(1, 3)이다. 2, 3번째 경로는 결국 20이라는 점에서 도착지까지의 경로가 중복이 된다.
그렇다면 중복되는 계산을 줄이기 위해서는 dp를 생각을 해야 한다.
출발지에서 20까지의 경로 수는 20의 상하좌우에서 20보다 큰 32, 25 두 지점까지의 경로 수의 합과 같다.

인접 4방향을 탐색하면서 재귀 형태로 최종 목적지까지 계속 타고 들어가 중간중간 추가 경로가 생길 시에 방법을 +1씩 누적시키는 방법이다.
또한 동시에 메모이제이션도 가능해지기 때문에 시간 복잡도를 많이 줄일 수 있다.
1. 메모이제이션과 구분하기 위해 DP 배열은 -1으로 초기화한다.
2. 처음 방문할 경우 -1 -> 0으로 변경시키고 배열 범위를 넘지 않고, 자신의 값이 더 큰 경우에 재귀를 실행하도록 한다.
3. 방문한 경우 0으로 값을 변경해주었기 때문에 재귀 시에 -1이 아닌 경우 메서드를 종료시켜 시간을 단축시킨다.
4. 목적지에 도달했을 때 경우의 수를 1씩 계속 누적하여 처음 시작한 좌표의 경우의 수를 구한다.
 */