package silver;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 11659. 구간 합 구하기 4
 */
public class Solution11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] box = new int[N+1];
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i <= N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + box[i]; 
        }

        for (int tc=0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()), J = Integer.parseInt(st.nextToken());
            int sum = dp[J] - dp[I-1];
            System.out.println(sum);
        }
    }
}
