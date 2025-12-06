package dp.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 1010. 다리 놓기
 */
public class Solution1010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
          
            if (N == M) {
                sb.append(1).append("\n");
                continue;
            } 

            long value = 1;
            for (int j = 0; j < N; j++) {
                value = value * (M - j);
                value = value / (j + 1);
            }
            sb.append(value).append("\n");
        }
        System.out.println(sb.toString());
    }
}
