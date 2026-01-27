package repeat.implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2161. 카드 1
 */
public class Solution2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[N ];
        for (int i=1; i<=N; i++) box[i-1] = i; 
        
        
    }
}
