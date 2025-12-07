package dp.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 1932. 정수 삼각형
 */
public class Solution1932{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] memo = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                memo[i][j] = Integer.parseInt(st.nextToken());             
            }
        }

        // for (int[] m : memo) {
        //     System.out.println("[DEBUG]: " + Arrays.toString(m));
        // }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) memo[i][j] += memo[i-1][j];
                else if (j == i) memo[i][j] += memo[i-1][j-1];
                else memo[i][j] += Math.max(memo[i-1][j-1], memo[i-1][j]); 
            }
        }

        // for (int[] b : memo) {
        //     System.out.println("[DEBUG]: " + Arrays.toString(b));
        // }

        System.out.println(Arrays.stream(memo[N-1]).max().getAsInt());
    }
}
