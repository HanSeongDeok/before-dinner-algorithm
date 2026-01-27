package dfs_bfs.baekjoon.bfs;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 1012. 유기농 배추
 */
public class Solution1012 {
    static boolean[][] memo;
    static Deque<int[]> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] box = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                box[n][m] = 1;
            }

            // for(int[] b : box) {
            // System.out.println(Arrays.toString(b));
            // }

            memo = new boolean[N][M];
            dq = new ArrayDeque<>();
            int answerByTc = 0;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (!memo[n][m] && box[n][m] == 1) {
                        memo[n][m] = true;
                        answerByTc += 1;
                        dq.offer(new int[] { n, m });
                        bfs(dq, box, N, M);
                    }
                }
            }
            System.out.println(answerByTc);
        }
    }

    static void bfs(Deque<int[]> dq, int[][] box, int N, int M) {
        int[] mapN = { 1, -1, 0, 0 };
        int[] mapM = { 0, 0, 1, -1 };

        while (!dq.isEmpty()) {
            int[] info = dq.poll();
            int curN = info[0], curM = info[1];

            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];

                if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                        !memo[nextN][nextM] && box[nextN][nextM] == 1) {
                    memo[nextN][nextM] = true;
                    dq.offer(new int[] { nextN, nextM });
                    // System.out.println("[DEBUG-BFS] ADD N: " + nextN + ", M: " + nextM);
                }
            }
        }
    }
}
