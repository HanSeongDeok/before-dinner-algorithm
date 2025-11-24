package dfs_bfs.baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 13549 숨바꼭질 3
 */
public class Solution13549 {
    static int answer = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int X = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
       
        int[] memo = new int[100001];
        Arrays.fill(memo, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {X, 0});
        int minValue = 0;

        while (!dq.isEmpty()) {
            int[] info = dq.poll();
            int curValue = info[0], second = info[1];
            if (curValue == N) {
                if (minValue == 0) {
                    minValue = second;
                } 
                if (second > minValue) {
                    continue;
                }
                answer = second;
                count++;
                continue;
            }
            for (int i=0; i < 3; i++) {
                int nextValue = operator(i, curValue);
                int sec = (i == 2) ? second : second + 1; 
                if (-1 < nextValue && nextValue < 100001 && memo[nextValue] > sec) {
                    memo[nextValue] = sec;
                    if (i == 2) {
                        dq.offerFirst(new int[] {nextValue, sec});
                    } else {
                        dq.offer(new int[] {nextValue, sec});
                    }
                }
            }
        }

        System.out.println(answer);
        // System.out.println(count);
    }
    private static int operator(int idx, int value) {
        if (idx == 0) return value + 1;
        else if (idx == 1) return value - 1;
        else return value * 2;
    }
}
