package dp.baekjoon;

import java.util.*;
import java.io.*;
public class Solution2579 {
    static int N, answer;
    static int[] box, memo;
    static boolean[] state;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        box = new int[N];
        memo = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box [i] = Integer.parseInt(st.nextToken());
        }
        
        // dfs(0, 0, 0);
        // System.out.println(answer);
        dp();
        System.out.println(answer);
    }

    private static void dp() {
        if (N == 1) {
            answer = box[0];
            return;
        }
        if (N == 2) {
            answer = box[0] + box[1];
            return;
        }
        memo[0] = box[0];
        memo[1] = box[0] + box[1];
        memo[2] = Math.max(box[2] + box[0], box[2] + box[1]);

        for (int i = 3; i < N; i++) {
            memo[i] = Math.max(
                box[i] + box[i-1] + memo[i-3], 
                box[i] + memo[i-2]
            );
        }

        answer = memo[N-1];
    }

    private static void dfs(int idx, int target, int count) {
        if (idx >= N) {
            answer = Math.max(answer, target);
            return;
        }

        if (count < 2) {
            dfs(idx + 1, target + box[idx], count + 1);
        } 
        if (idx + 2 < N) {
            dfs(idx + 2, target + box[idx + 2], count = 0);
        } 
    }
    
    
}
