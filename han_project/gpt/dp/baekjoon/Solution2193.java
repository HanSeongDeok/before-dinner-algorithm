package dp.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2193. 이친수
 */
public class Solution2193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long memo[] = new long[N]; 
        
        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }
        memo[0] = 1; 
        memo[1] = 1;
        for (int i = 2; i < N; i++) {
            memo[i] = memo[i-1] + memo[i-2]; 
        }

        System.out.println(memo[N-1]);
    }
}
