package dp.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 11053. 가장 긴 증가하는 부분 수열 (LIS)
 */
public class Solution11053 {
   
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[N];
        int[] memo = new int[N];
        Arrays.fill(memo, 1);
        
        //System.out.println(Arrays.toString(memo));
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        
        // System.out.println(Arrays.toString(box));
        for (int i=1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
        }
        // System.out.println(Arrays.toString(memo));
        System.out.println(Arrays.stream(memo).max().getAsInt());
        
    }
}
