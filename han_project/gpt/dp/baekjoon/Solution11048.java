package dp.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 11048. 이동하기
 */
public class Solution11048 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        int[][] memo = new int[N+1][M+1];

        for (int n=1; n < N+1; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=1; m < M+1; m++) {
                memo[n][m] = Integer.parseInt(st.nextToken()); 
            }
        }

        // for (int[] m : memo) {
        //     System.out.println(Arrays.toString(m));
        // }

        for (int n=1; n < N+1; n++) {
            for (int m=1; m < M+1; m++) {
                int maxValue = 0;
                maxValue = Math.max(memo[n-1][m], memo[n][m-1]);
                maxValue = Math.max(maxValue, memo[n-1][m-1]);
                memo[n][m] += maxValue;
            }
        }

        // for (int[] m : memo) {
        //     System.out.println(Arrays.toString(m));
        // }

        System.out.println(memo[N][M]);
    }
}
