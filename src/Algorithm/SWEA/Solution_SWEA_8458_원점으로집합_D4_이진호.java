package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8458_원점으로집합_D4_이진호 {
    static int N, evenCnt, oddCnt;
    static long result;
    static long[] dist;
    static boolean[] even;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            dist = new long[N];
            even = new boolean[N];
            evenCnt = 0;
            oddCnt = 0;
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                dist[i] = Math.abs(Long.parseLong(st.nextToken())) + Math.abs(Long.parseLong(st.nextToken()));
                if(dist[i] % 2 == 0){
                    even[i] =true;
                    evenCnt++;
                }else{
                    oddCnt++;
                }
            }
            if(evenCnt == 0 || oddCnt == 0){
                result = 0;
                for (int i = 0; i < N; i++) {
                    result = Math.max(result, calc(i));
                }
                sb.append("#").append(tc).append(" ").append(result).append("\n");
            }else{
                result = -1;
                sb.append("#").append(tc).append(" ").append(result).append("\n");
            }
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static long calc(int n){
        long i = (long) Math.sqrt(2*dist[n]);
        while(true){
            if(i*(i+1)/2 < dist[n]){
                i++;
            }else{
                break;
            }
        }
        if(even[n]){
            while(i%4 != 3 && i%4 != 0){
                i++;
            }
        }else{
            while(i%4 != 1 && i%4 != 2){
                i++;
            }
        }

        return i;
    }
} // end of class
