package repeat.bfs;

import java.io.*;
import java.util.*;

public class Solution1012 {
    private static boolean[][] state;
    private static int[][] box;
    private static int N, M;
    private static int[] mapM = { 0, 0, 1, -1 };
    private static int[] mapN = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            state = new boolean[N][M];
            box = new int[N][M];

            int answer = 0;
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
                box[n][m] = 1;
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (!state[n][m] && box[n][m] == 1) {
                        bfs(n, m);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int n, int m) {
        state[n][m] = true;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { n, m });

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1];
            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                        !state[nextN][nextM] && box[nextN][nextM] == 1) {
                    state[nextN][nextM] = true;
                    dq.add(new int[] { nextN, nextM });
                }
            }
        }
    }
}
