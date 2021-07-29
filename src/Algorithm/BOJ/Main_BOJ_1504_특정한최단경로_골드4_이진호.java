package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특정한최단경로_골드4_이진호 {
    static final int INF = 1000000;
    static ArrayList<Node>[] graph;
    static int N, E, from, to, cost, v1, v2, result;

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
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        result = dijkstra(1, v1) + dijkstra(v2, N) < dijkstra(1, v2) + dijkstra(v1, N) ? dijkstra(1, v1) + dijkstra(v2, N) : dijkstra(1, v2) + dijkstra(v1, N);
        result += dijkstra(v1, v2);

        System.out.print(result >= INF ? -1 : result);
    } // end of main
    static int dijkstra(int start, int end){
        if(start == end) return 0;
        int[] dist = new int[N +1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(current.to== end) return dist[current.to];
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
    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int value) {
            this.to = to;
            this.cost = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost >o.cost ? 1:-1;
        }
    }
} // end of class
