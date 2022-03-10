package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_2644_촌수계산_실버2_이진호 {
    static int n, m, start, end, result = Integer.MAX_VALUE;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(start, 0);
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    } // end of main
    private static void dfs(int start, int depth) {
        if(start == end) {
            result = Math.min(depth, result);
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            int cur = graph[start].get(i);
            if(visited[cur]) continue;
            visited[start] = true;
            dfs(cur, depth+1);
            visited[cur] = false;
        }
    } // end of dfs
} // end of class
