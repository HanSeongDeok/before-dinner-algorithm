package brute_force.baekjoon.repeat;

import java.io.*;
import java.util.*;

/**
 * 복습 - N-Queen 오답 
 * @TODO 오답노트 작성하기 
 */
public class Solution9663 {
    private static int N;
    private static int[] state;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        state = new int[N];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if (idx == N) {
            answer++;
            return;
        }
        for (int j = 1; j <= N; j++) {
            if (isValid(idx, j)) {
                state[idx] = j;
                dfs(idx + 1);
                state[idx] = 0;
            }
        }
    }

    private static boolean isValid(int y, int x) {
        for (int i = 0; i < N; i++) {
            if (state[i] == x) return false;
        }

        int cnt = 0;
        for (int i = y; i >= 0; i--) {
            if (state[i] == x + cnt++) return false;
        }

        cnt = 0;
        for (int i = y; i >= 0; i--) {
            if (state[i] == x - cnt++) return false;
        }

        return true;
    }
}
