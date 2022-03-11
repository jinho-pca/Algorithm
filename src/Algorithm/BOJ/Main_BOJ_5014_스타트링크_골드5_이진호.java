package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크_골드5_이진호 {
    static int F, S, G, U, D, result = Integer.MAX_VALUE;
    static int[] dv;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dv = new int[] {U, -D};
        visited = new boolean[F+1];
        bfs();
        System.out.print(result == Integer.MAX_VALUE ? "use the stairs" : result);
    } // end of main
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == G) {
                result = Math.min(result, cur[1]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = cur[0] + dv[i];
                if(next > 0 && next <= F && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, cur[1]+1});
                }
            }
        }
    } // end of bfs
} // end of class
