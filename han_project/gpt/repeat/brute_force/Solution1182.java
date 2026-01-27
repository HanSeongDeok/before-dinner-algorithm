package repeat.brute_force;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON 1182. 부분수열의 합
 * <다시 풀기>
 */
public class Solution1182 {
    static int answer = 0;
    static int N, S;
    static int[] numbers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i< N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs2(0, 0);
        System.out.println(answer-1);
    }

    private static void dfs2(int target, int idx) {
        if (target == S) {
            answer++;
        }
        for (int i = idx; i < N; i++) {
            dfs2(target + numbers[i], i + 1);
        }
    }

    private static void dfs(int target, int idx) {
        if (idx == N) {
            if (target == S) {
                answer++;
            }
            return;
        }
        dfs(target, idx + 1);
        dfs(target + numbers[idx], idx + 1);
    }
}
