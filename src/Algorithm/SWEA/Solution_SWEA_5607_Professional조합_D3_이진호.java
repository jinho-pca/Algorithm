package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_Professional조합_D3_이진호 {
    static int N, R;
    static final int mod = 1234567891;
    static long[] factorial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            factorial = new long[N+1];
            factorial[0] = 1;
            for (int i = 1; i <= N; i++) {
                factorial[i] = factorial[i-1] * i % mod;
            }
            long denominator = (factorial[N-R] * factorial[R]) % mod;
            long updatedDenominator = Fermat(denominator, mod-2);
            sb.append("#").append(tc).append(" ").append((factorial[N]*updatedDenominator) % mod).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static long Fermat(long a, long p){
        if(p == 0) return 1;
        long tmp = Fermat(a, p/2);
        long result = (tmp * tmp) % mod;
        if(p % 2 == 0){
            return result;
        }else{
            return (a * result) % mod;
        }
    } // end of Fermat
} // end of class
