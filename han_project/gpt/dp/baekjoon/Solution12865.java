package dp.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 12865. 평범한 배낭
 */
public class Solution12865 {
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int[] weights = new int[N+1]; 
        int[] values = new int[N+1];
        int[][] memo = new int[N+1][K+1];

        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            weights[i] = weight;
            values[i] = value;
        }

        for (int i=1; i <= N; i++) {
            for (int j=1; j <= K; j++) {
                if (weights[i] > j) {
                    memo[i][j] = memo[i-1][j];
                } else {
                    // 현재 인덱스에 속하는 무게 + 더 넣을 수 있는 무게 
                    int value1 = memo[i-1][j-weights[i]] + values[i];
                    // 더 넣을 수 없는 이전 인덱스의 무게
                    int value2 = memo[i-1][j];
                    memo[i][j] = Math.max(value1, value2) ;
                }
            }
        }

        // for (int[]m : memo) {
        //     System.out.println(Arrays.toString(m));
        // }
        System.out.println(memo[N][K]);
    }
}
