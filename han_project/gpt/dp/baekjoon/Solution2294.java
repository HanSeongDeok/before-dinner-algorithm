package dp.baekjoon;

import  java.io.*;
import  java.util.*;

/**
 * BAEKJOON
 * 2294. 동전 2
 * 
 * DP 문제 -> 복습 필수
 */
public class Solution2294 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int box[] = new int[N];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int b : box) {
            for (int i = b; i <= K; i ++) {
                if (dp[i - b] == Integer.MAX_VALUE) continue; 
                dp[i] = Math.min(dp[i], dp[i - b] + 1);
            }
        }

        int answer = dp[K] == Integer.MAX_VALUE ? -1 : dp[K];
        System.out.println(answer);
    }
}
