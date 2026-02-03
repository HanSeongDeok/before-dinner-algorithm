package bronze;

import java.io.*;
import  java.util.*;
/**
 * BAEKJOON
 * 27959 초코바
 */
public class Solution27959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        System.out.println((N * 100 >= M) ? "Yes" : "No");
    }
}
