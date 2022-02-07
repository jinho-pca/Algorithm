package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_실버2_이진호 {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) dfs(i);
        }
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb.toString());
    } // end of main
    private static void dfs(int index) {
        if(visited[index]) return;

        visited[index] = true;
        for(int x : list[index]) {
            if(!visited[x]) {
                parents[x] = index;
                dfs(x);
            }
        }
    }
} // end of class