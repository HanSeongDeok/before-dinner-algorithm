package dp.baekjoon;

import  java.io.*;
import  java.util.*;

/**
 * BAEKJOON 
 * 11049. 행렬 곱셈 순서
 * 
 *  오답 -> 너무 어려움 다시 이해하도록...
 */
public class Solution11049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] r = new int[N + 1];
        int[] c = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][N + 1];
        long INF = Long.MAX_VALUE / 4;

        for (int len = 2; len <= N; len++) {          // 구간 길이
            for (int i = 1; i + len - 1 <= N; i++) {  // 시작
                int j = i + len - 1;                  // 끝
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {         // 분할점
                    long cost = dp[i][k] + dp[k + 1][j] + (long) r[i] * c[k] * c[j];
                    if (cost < dp[i][j]) dp[i][j] = cost;
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}   

