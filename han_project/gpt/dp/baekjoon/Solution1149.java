package dp.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1149. RGB 거리
 */
public class Solution1149 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        // box = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()); 
            dp[i][1] = Integer.parseInt(st.nextToken()); 
            dp[i][2] = Integer.parseInt(st.nextToken()); 
        }

       for (int i = 1; i < N; i++) {
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]); 
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]); 
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]); 
       } 

       for (int i=0; i < 3; i++) {
            answer = Math.min(dp[N-1][i], answer) ;
       }
       System.out.println(answer);
    }
}
