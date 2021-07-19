package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BOJ_5021_왕위계승_실버1_이진호 {
    static int n, m;
    static double max = -1.0;
    static String result;
    static HashMap<String, Double> D = new HashMap<>();
    static HashMap<String, String[]> M = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        D.put(br.readLine(), 1.0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M.put(st.nextToken(), new String[]{st.nextToken(), st.nextToken()});
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            double tmp = dfs(s, M, D);
            if(tmp > max){
                max = tmp;
                result = s;
            }
        }
        System.out.println(result);
    } // end of main
    private static double dfs(String s, HashMap<String, String[]> M, HashMap<String, Double> D){
        if(D.containsKey(s)) return D.get(s);
        if(!M.containsKey(s)) return 0L;
        String[] pa = M.get(s);
        double x = (dfs(pa[0], M, D) + dfs(pa[1], M, D)) / 2;
        D.put(s, x);
        return x;
    }
} // end of class

/*
package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BOJ_5021_왕위계승_실버1_이진호 {
    static int n, m;
    static long max = -1;
    static String result;
    static HashMap<String, Long> D = new HashMap<>();
    static HashMap<String, String[]> M = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        D.put(br.readLine(), 1L << 62);
        System.out.println(1L << 62);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M.put(st.nextToken(), new String[]{st.nextToken(), st.nextToken()});
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            long tmp = dfs(s, M, D);
            if(tmp > max){
                max = tmp;
                result = s;
            }
        }
        System.out.println(result);
    } // end of main
    private static long dfs(String s, HashMap<String, String[]> M, HashMap<String, Long> D){
        if(D.containsKey(s)) return D.get(s);
        if(!M.containsKey(s)) return 0L;
        String[] pa = M.get(s);
        long x = (dfs(pa[0], M, D) + dfs(pa[1], M, D)) / 2;
        System.out.println(x);
        D.put(s, x);
        return x;
    }
} // end of class
 */