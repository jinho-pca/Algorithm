package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특정한최단경로_골드4_이진호 {
    static final long INF = 1000000000;
    static int N, E, v1, v2;
    static long result;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static class Node {
        int to;
        long cost;

        public Node(int to, long value) {
            this.to = to;
            this.cost = value;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N +1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long dist1tov1 = dijkstra(1, v1);
        long dist1tov2 = dijkstra(1, v2);
        long distv2toN = dijkstra(v2, N);
        long distv1toN = dijkstra(v1, N);
        long distv1tov2 = dijkstra(v1, v2);
        result = dist1tov1 + distv2toN < dist1tov2 + distv1toN ? dist1tov1 + distv2toN : dist1tov2 + distv1toN;
        result += distv1tov2;

        System.out.print(result >= INF ? -1 : result);
    } // end of main
    static long dijkstra(int start, int end){
        if(start == end) return 0;
        long[] dist = new long[N +1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {return Long.compare(o1.cost, o2.cost);});
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.to == end) return dist[current.to];
            for(int i = 0; i < graph[current.to].size(); i++){
                Node next = graph[current.to].get(i);
                if(dist[next.to] > dist[current.to] + next.cost){
                    dist[next.to] = dist[current.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return INF;
    } // end of dijkstra
} // end of class
