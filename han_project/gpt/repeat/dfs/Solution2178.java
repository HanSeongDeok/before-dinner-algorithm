package repeat.dfs;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 2178. 미로 탐색  
 * <복습> 정답: 시간 15분 소요
 */
public class Solution2178 {
    private static int answer = Integer.MAX_VALUE;
    private static int[][] box;
    private static boolean[][] state;
    private static int N, M;
    private static int[] mapN ={1 , -1, 0, 0};
    private static int[] mapM = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        state = new boolean[N][M];

        for (int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        
        dfs(new int[]{0, 0, 1});
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int[] infos) {
        int curN = infos[0], curM = infos[1], distance = infos[2];
        if (curN == N-1 && curM == M-1) {
            answer = Math.min(distance, answer);
            return;
        }

        for (int i=0; i < 4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                !state[nextN][nextM] && box[nextN][nextM] == 1) {
                    state[nextN][nextM] = true;
                    dfs(new int[] {nextN, nextM, distance + 1});
            }
        }
    }
}

/* 
4 6
101111
101010
101011
111011

15
*/