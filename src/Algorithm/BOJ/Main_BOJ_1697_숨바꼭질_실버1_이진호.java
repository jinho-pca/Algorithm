package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1697_숨바꼭질_실버1_이진호 {
    static int start, end, result = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] dv = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(start);
        System.out.print(result);
    } // end of main
    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited[start] = true;
        q.offer(new int[] {start, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == end) {
                result = Math.min(result, cur[1]);
                return;
            }
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if(i == 2) {
                    next = cur[0] * dv[i];
                } else {
                    next = cur[0] + dv[i];
                }
                if(next >= 0 && next < 100001 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, cur[1] + 1});
                }
            }
        }
    } // end of bfs
} // end of class
