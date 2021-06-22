package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
2개의 우선순위 큐 사용
가방 -> 오름차순
보석 -> 오름차순(무게)
리스트 -> 내림차순(값)
가방을 무게가 작은 순서대로 하나씩 꺼내서 보석을 무게가 가벼운순서대로 꺼내면서 가방에 넣을 수 없다면 다시 보석pq에 넣고
넣을 수 있는 보석이라면 리스트pq에 넣는다. 가방하나당 리스트에는 여러개가 들어가지만 그 중 1개만 꺼내면 값이 가장 큰 보석이
추출된다. -> 가방 개수 만큼 반복
*/
public class Main_BOJ_1202_보석도둑_골드2_이진호 {
    static class Jewelry implements Comparable<Jewelry>{
        int weight;
        int cost;

        public Jewelry(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
        @Override
        public int compareTo(Jewelry j){
            return this.weight - j.weight;
        }
    }
    static int N, K;
    static long result;
    static PriorityQueue<Integer> bag = new PriorityQueue<>();
    static PriorityQueue<Jewelry> jewelry = new PriorityQueue<>();
    static PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            jewelry.offer(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < K; i++) bag.offer(Integer.parseInt(br.readLine()));

        while(!bag.isEmpty()){
            int tmpBag = bag.poll();
            while(!jewelry.isEmpty()){
                Jewelry tmpJ = jewelry.poll();
                if(tmpJ.weight > tmpBag){
                    jewelry.offer(tmpJ);
                    break;
                }else list.offer(tmpJ.cost);
            }
            if(!list.isEmpty()) result += list.poll();
        }
        System.out.print(result);
    } // end of main
} // end of class
