package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Lecture {
    int start;
    int end;
    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Main_BOJ_11000_강의실배정_골드5_이진호 {
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures, (o1, o2) -> (o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start));
        pq.offer(lectures[0].end);
        for(int i = 1; i < N; i++) {
            if(pq.peek() <= lectures[i].start) pq.poll();
            pq.offer(lectures[i].end);
        }
        System.out.print(pq.size());
    } // end of main
} // end of class
