package dfs_bfs.baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 숨바꼭질 2
 * 
 * 주의 사항: 
 * int[] memo - 방문 기록 등은 int[]의 두 번째 원소를 포함해 시간마다 체크해야 함 (int[] 사용 필수)
 * boolean[] memo - 최소시간은 굳이 직접 체크하면서 저장하지 않아도, 큐에 담긴 순서 자체가 BFS 특성상 최단 시간 도달을 보장함
 */
public class Solution12851 {
    
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
                if (-1 < nextValue && nextValue < 100001 && memo[nextValue] >= second+1) {
                    memo[nextValue] = second+1;
                    dq.offer(new int[] {nextValue, second+1});
                }
            }
        }

        System.out.println(answer);
        System.out.println(count);
    }
    private static int operator(int idx, int value) {
        if (idx == 0) return value + 1;
        else if (idx == 1) return value - 1;
        else return value * 2;
    }
}
