package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_2470_두용액_골드5_이진호 {
    static int N, result = Integer.MAX_VALUE;
    static ArrayList<Integer> ph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ph.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(ph);
        int left = 0;
        int right = ph.size() - 1;
        result = ph.get(left) + ph.get(right);
        int base = left;
        int acid = right;

        while(left < right){
            int tmp = ph.get(left) + ph.get(right);
            if(Math.abs(tmp) < Math.abs(result)) {
                base = left;
                acid = right;
                result = tmp;
            }
            if(tmp < 0) left++;
            else right--;
        } // end of while
        System.out.print(ph.get(base) + " " + ph.get(acid));
    } // end of main
}// end of class
