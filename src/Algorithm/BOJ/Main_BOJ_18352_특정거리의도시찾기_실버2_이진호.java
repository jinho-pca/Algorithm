package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_실버2_이진호 {
    static int N, M, K, X, INF = Integer.MAX_VALUE;
    static int[] distance;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }
        dijkstra(X);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if(distance[i] == K) list.add(i);
        }
        if(list.size() == 0) sb.append(-1);
        else {
            for(int x : list) sb.append(x).append("\n");
        }
        System.out.print(sb);
    } // end of main
    private static void dijkstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        distance[start] = 0;
        pq.offer(start);
        while(!pq.isEmpty()) {
            int n = pq.poll();
            for (int i = 0; i < graph[n].size(); i++) {
                int m = graph[n].get(i);
                if(distance[m] > distance[n] + 1) {
                    distance[m] = distance[n] + 1;
                    pq.offer(m);
                }
            }
        }
    } // end of dijkstra
} // end of class
