package Algorithm.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3238_이항계수구하기_D5_이진호 {
    public static long n, r;
    public static int t, m;
    public static long[] f=new long[100000];
    public static long pow(long a, long p) {
        long ret=1;
        while(p>0){
            if((p&1)==1){
                ret*=a;
                ret%=m;
            }
            a*=a;
            a%=m;
            p/=2;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC= Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n= Long.parseLong(st.nextToken());
            r= Long.parseLong(st.nextToken());
            m= Integer.parseInt(st.nextToken());

            f[0]=1;
            for(int i=1; i<m; i++) f[i]=(f[i-1]*i)%m;
            long ret=1;
            while(n>0 || r>0){
                long a=n%m;
                long b=r%m;
                if(a<b) ret=0;
                if(ret==0) break;
                ret*=f[(int)a];
                ret%=m;
                ret*=pow((f[(int)b]*f[(int)a-(int)b])%m, m-2);
                ret%=m;
                n/=m;
                r/=m;
            }
            System.out.println("#"+tc+" "+ret);
        }
    }
} // end of class
