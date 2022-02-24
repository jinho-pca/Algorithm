package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1753_최단경로_골드5_이진호 {
    static int V, E, K;
    static int[] distance;
    static ArrayList<Node>[] graph;
    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }
        System.out.print(sb);
    } // end of main
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return o1.cost - o2.cost;});
        boolean[] visited = new boolean[V+1];
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;
            if(visited[cur]) continue;
            visited[cur] = true;

            for(Node node : graph[cur]) {
                if(distance[node.to] > distance[cur] + node.cost) {
                    distance[node.to] = distance[cur] + node.cost;
                    pq.offer(new Node(node.to, distance[node.to]));
                }
            }
        }
    }
} // end of class
