package dfs_bfs.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2178. 미로 탐색
 */
public class Solution2178 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int [][] box = new int[N][M];
        for (int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String values = st.nextToken();
            for (int j=0; j < M; j++) {
                box[i][j] = Integer.parseInt(String.valueOf(values.charAt(j)));
            }
        }

        for (int[] b : box) {
            System.out.println(Arrays.toString(b));
        }

        int[] mapN = {1, -1, 0, 0};
        int[] mapM = {0, 0, 1, -1};

        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] memo = new boolean[N][M];
        memo[0][0] = true;
        dq.offer(new int[] {0, 0, 1});

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1], dist = infos[2];

            if (curN == N-1 && curM == M-1){
                answer = dist;
                break;
            }

            for (int i=0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                    !memo[nextN][nextM] && box[nextN][nextM] == 1) {
                        memo[nextN][nextM] = true;
                        dq.offer(new int[] {nextN, nextM, dist + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
