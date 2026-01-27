package dp.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 1912. 연속 합
 */
public class Solution1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] memo = new int[N], box = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken()); 
            memo[i] = value;
            box[i] = value;
        } 

        // System.out.println("[DEBUG]: " + Arrays.toString(memo));

        for (int i = 1; i < N; i++) { 
            memo[i] = Math.max(box[i] + memo[i-1], box[i]);
        }
        
        // System.out.println("[DEBUG]: " + Arrays.toString(memo));

        System.out.println(Arrays.stream(memo).max().getAsInt());
    }
}
