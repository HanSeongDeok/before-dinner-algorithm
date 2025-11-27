package brute_force.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 9663. N-Queen
 */
public class Solution9663 {
    static int N;
    static int answer = 0;
    static boolean[][] memo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        memo = new boolean[N][N];
        
        dfs(0);
        System.out.println(answer);
    }
    
    private static void dfs(int idx) {
        if (idx == N) {
            answer++;
            return;
        }
        for (int i=0; i < N; i++) {
            if (isValid(idx, i)) {
                memo[idx][i] = true;
                dfs(idx + 1);
                memo[idx][i] = false;
            }
        }
    }
    private static boolean isValid(int idx, int col) {
        for (int i = 0; i < idx; i++) {
            if (memo[i][col]) {
                return false;
            }
            if (col-(idx-i) >= 0 && memo[i][col-(idx-i)]) {
                return false;
            }
            if (col+(idx-i) < N && memo[i][col+(idx-i)]) {
                return false;
            }
        }
        return true;
    }


}