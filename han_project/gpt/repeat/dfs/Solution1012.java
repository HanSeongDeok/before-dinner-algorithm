package repeat.dfs;

import java.io.*;
import java.util.*;

public class Solution1012 {
    private static int N, M;
    private static int[] mapN ={1 , -1, 0, 0};
    private static int[] mapM = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); 
            N = Integer.parseInt(st.nextToken());;
            int K = Integer.parseInt(st.nextToken());
            int[][] box = new int[N][M];
            boolean[][] state= new boolean[N][M];

            for (int k=0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                box[y][x] = 1;
            }

            int answer = 0;
            for (int n=0; n < N; n++) {
                for (int m=0; m < M; m++) {
                    if (!state[n][m] && box[n][m] == 1) {
                        state[n][m] = true;
                        answer++;
                        dfs(n, m, box, state);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    private static void dfs(int curN, int curM, int[][] box, boolean[][] state) {
        for (int i =0; i < 4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (-1 < nextN && nextN < N && -1 < nextM &&  nextM < M &&
                !state[nextN][nextM] && box[nextN][nextM] > 0 ){
                    state[nextN][nextM] = true;
                    dfs(nextN, nextM, box, state);
            }
        }
    }
}

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

5
1
*/
