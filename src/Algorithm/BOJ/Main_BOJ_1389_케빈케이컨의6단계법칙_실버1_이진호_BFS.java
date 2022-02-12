package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1389_케빈케이컨의6단계법칙_실버1_이진호_BFS {
    static int N, M, min = Integer.MAX_VALUE, result;
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            distance = new int[N+1];
            visited = new boolean[N+1];
            int sum = bfs(i);
            if(sum < min) {
                min = sum;
                result = i;
            }
        }
        System.out.print(result);
    } // end of main
    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int dis = 0;
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int pick : graph[cur]) {
                if(!visited[pick]) {
                    visited[pick] = true;
                    distance[pick] = distance[cur] + 1;
                    q.offer(pick);
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            dis += distance[i];
        }
        return dis;
    }
} // end of class
