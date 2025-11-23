package dfs_bfs.baekjoon;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 1697. 숨바꼭질
 */
public class Solution1697 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int X = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        boolean[] memo = new boolean[100001];
        Deque<int[]> dq = new ArrayDeque<>();
        memo[X] = true;
        dq.offer(new int[] {X, 0});

        while (!dq.isEmpty()) {
            int[] info = dq.poll();
            int curValue = info[0], second = info[1];
            if (curValue == N) {
                answer = second;
                break;
            }
            for (int i=0; i < 3; i++) {
                int nextValue = operator(i, curValue);
                if (-1 < nextValue && nextValue < 100001 && !memo[nextValue]) {
                    memo[nextValue] = true;
                    dq.offer(new int[] {nextValue, second+1});
                }
            }
        }

        System.out.println(answer);
    }
    private static int operator(int idx, int value) {
        if (idx == 0) return value + 1;
        else if (idx == 1) return value - 1;
        else return value * 2;
    }
}
