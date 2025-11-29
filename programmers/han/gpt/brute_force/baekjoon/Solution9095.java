package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 9095. 1, 2, 3 더하기
 */
public class Solution9095 {
    static int target;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            target = Integer.parseInt(st.nextToken());
            count = 0;
            dfs(0);
            sb.append(count).append("\n");    
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int value) {
        if (target < value){
            return;
        }

        if (target == value) {
            count++;
            return;
        }

        dfs(value + 1);
        dfs(value + 2);
        dfs(value + 3);
    } 
}
