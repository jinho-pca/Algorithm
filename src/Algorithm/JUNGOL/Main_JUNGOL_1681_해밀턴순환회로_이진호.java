package Algorithm.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JUNGOL_1681_해밀턴순환회로_이진호 {
    private static int N;
    private static int result = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);
        System.out.println(result);
    } // end of main
    private static void dfs(int start, int depth, int distance){
        if(distance >= result) return;
        if(depth == N-1){
            if(map[start][0] != 0){
                result = Math.min(result, distance + map[start][0]);
            }
            return;
        }
        for (int i = 1; i < N; i++) { // 0인덱스에서 출발하니까 0을 갈 필요가없다. => i = 1 부터 시작
            if(map[start][i] != 0 && !visited[i]){
                visited[i] = true;
                dfs(i, depth+1, map[start][i] + distance);
                visited[i] = false;
            }
        }
    }
} // end of class
