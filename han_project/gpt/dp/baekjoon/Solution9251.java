package dp.baekjoon;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 9251. LCS 
 */
public class Solution9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S1 = st.nextToken();
        int N = S1.length();
        char[] boxS1 = new char[N+1];
        for (int i = 1; i <= N; i++) {
            boxS1[i] = S1.charAt(i-1);
        }
        // System.out.println("[DEBUG]: " + Arrays.toString(boxS1));

        st = new StringTokenizer(br.readLine());
        String S2 = st.nextToken();
        int M = S2.length();
        char[] boxS2 = new char[M+1];
        for (int i = 1; i <= M; i++) {
            boxS2[i] = S2.charAt(i-1);
        }
        // System.out.println("[DEBUG]: " + Arrays.toString(boxS2));
        
        int[][] memo = new int[N+1][M+1];
        for (int i=1; i <= N; i++) {
            for (int j=1; j <= M; j++) {
                memo[i][j] = (boxS1[i] == boxS2[j]) ? 
                    memo[i-1][j-1] + 1 : 
                    Math.max(memo[i-1][j], memo[i][j-1]);
            }   
        }

        // for (int[] m : memo) {
        //     System.out.println("[DEBUG]: " + Arrays.toString(m));
        // }

        System.out.println(memo[N][M]);
    }
}


