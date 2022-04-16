package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_1707_이분그래프_골드4_이진호 {
    static int TC, V, E;
    static boolean isEnd, endTest;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V+1];
            visited = new int[V+1];
            isEnd = false;
            endTest = false;
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }
            for (int i = 1; i <= V; i++) {
                if(isEnd) {
                    sb.append("NO").append("\n");
                    endTest = true;
                    break;
                }
                if(visited[i] == 0) {
                    dfs(i, 1);
                }
            }
            if(!endTest) sb.append("YES").append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static void dfs(int start, int number) {
        if(isEnd) return;
        visited[start] = number;
        for(int next : graph[start]) {
            if(visited[start] == visited[next]) {
                isEnd = true;
                return;
            } else if(visited[next] == 0) {
                if(visited[start] == 1) dfs(next, 2);
                else dfs(next, 1);
            }
        }
    }
} // end of class
