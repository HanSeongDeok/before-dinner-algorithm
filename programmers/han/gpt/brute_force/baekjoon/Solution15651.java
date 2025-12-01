package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 15651. N과 M (3)
 */
public class Solution15651 {
    static int N; 
    static int M;
    static StringBuilder answer = new StringBuilder(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dfs(0, new int[M]);
        System.out.println(answer.toString());
    }

    static private void dfs(int idx, int[] targets) {
        if (idx == M) {
            for (int i : targets) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i=1; i <= N; i++) {
                targets[idx] = i;
                dfs(idx + 1, targets);
            } 
        }
    }
