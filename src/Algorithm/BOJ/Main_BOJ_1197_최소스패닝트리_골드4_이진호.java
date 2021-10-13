package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1197_최소스패닝트리_골드4_이진호 {
    static int V, E, result;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
    static class Node{
        int from;
        int to;
        int cost;
        Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node node = new Node(from, to, cost);

            pq.offer(node);
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();

            union(node.from, node.to, node.cost);
        }

        System.out.print(result);
    } // end of main
    private static void union(int from, int to, int cost){
        int repA = find(from);
        int repB = find(to);
        if(repA == repB) return;
        else{
            parent[repA] = repB;
            result += cost;
        }
    } // end of union
    private static int find(int x){
        if(parent[x] == x) return x;
        else{
            parent[x] = find(parent[x]);
        }
        return parent[x];
    } // end of find
} // end of class
