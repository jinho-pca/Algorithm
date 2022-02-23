package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티_골드3_이진호 {
    static int N, M, X, max = Integer.MIN_VALUE;
    static int[] goDistance, backDistance;
    static boolean[] visited;
    static ArrayList<Node>[] nGraph, rGraph;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        nGraph = new ArrayList[N+1];
        rGraph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nGraph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nGraph[from].add(new Node(to, cost));
            rGraph[to].add(new Node(from, cost));
        }
        goDistance = dijkstra(nGraph, X);
        backDistance = dijkstra(rGraph, X);
        for (int i = 1; i <= N; i++) {
            int sum = goDistance[i] + backDistance[i];
            max = Math.max(max, sum);
        }
        System.out.print(max);
    } // end of main
    private static int[] dijkstra(ArrayList<Node>[] graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] res = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        res[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Node node : graph[cur]) {
                if(res[node.to] > res[cur] + node.cost) {
                    res[node.to] = res[cur] + node.cost;
                    pq.offer(new Node(node.to, res[node.to]));
                }
            }
        }
        return res;
    }
} // end of class
