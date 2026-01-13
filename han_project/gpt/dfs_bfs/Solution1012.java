package dfs_bfs;
import java.io.*;
import java.util.*;

public class Solution1012 {
    private final static int[] mapN = {1, -1, 0, 0};
    private final static int[] mapM = {0, 0, 1, -1};
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++ ) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); 
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int box[][] = new int[N][M];
            boolean visited[][] = new boolean[N][M];
            Deque<int[]> dq = new ArrayDeque<>();
            int answer = 0;

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
                box[n][m] = 1; 
            }
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (!visited[n][m] && box[n][m] == 1) {
                        answer++;
                        bfs(dq, box, visited, n, m);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(Deque<int[]> dq, int box[][], boolean visited[][], int n, int m) {
        dq.add(new int[] {n, m});
        visited[n][m] = true;

        while(!dq.isEmpty()) {
            int[] info = dq.poll();
            int curN = info[0], curM = info[1];

            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && - 1 < nextM && nextM < M &&
                    !visited[nextN][nextM] && box[nextN][nextM] == 1) {
                        visited[nextN][nextM] = true;
                        dq.add(new int[] {nextN, nextM});
                }
            }
        }
    }
}
