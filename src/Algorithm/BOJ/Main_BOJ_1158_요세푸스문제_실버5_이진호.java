package Algorithm.BOJ;
/**
 * BJ_1158_요세푸스문제_실버5
 *
 * @author jinho_pca
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1158_요세푸스문제_실버5_이진호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                int x = queue.poll();
                queue.offer(x);
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
