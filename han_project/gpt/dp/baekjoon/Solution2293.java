package dp.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * @TODO 생각하기 너무 어려움 다시 복습하기
 * 2293. 동전 1
 */
public class Solution2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] box = new int[N];
        int[] memo = new int[K+1];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = Integer.parseInt(st.nextToken());
        }

        memo[0] = 1;
        for (int i=0; i < N; i++) {
            int value = box[i];
            for (int j = value; j <= K; j++) {
                memo[j] += memo[j - value];
            }
        }

        System.out.println(memo[K]);
    }
}
