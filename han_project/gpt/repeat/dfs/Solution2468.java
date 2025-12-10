package repeat.dfs;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 2468. 안전 영역
 * <복습> - 정답
 *  소요시간 - 30분 
 */
public class Solution2468 {
    private static int N;
    private static int[][] box;
    private static int[] mapN = new int[] {1, -1, 0, 0};
    private static int[] mapM = new int[] {0, 0, 1, -1};
    private static int answer = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        box = new int [N][N];
        int maxValue = 1;
        
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, box[i][j]);
            }
        }

        for (int i=1; i < maxValue; i++) {
            int [][] rainBox = createRainBox(i);
            boolean state[][] = new boolean[N][N];
            int count= 0;
            for (int j=0; j < N; j++) {
                for (int k=0; k < N; k++) {
                    if (!state[j][k] && rainBox[j][k] > 0) {
                        state[j][k] = true;
                        count++;
                        dfs(j, k, rainBox, state);
                    }
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }

    private static void dfs (int curN, int curM, int[][] rainBox, boolean[][] state) {
        for (int i=0; i<4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (-1 < nextN && nextN < N && -1 < nextM &&  nextM < N &&
                !state[nextN][nextM] && rainBox[nextN][nextM] > 0 ){
                    state[nextN][nextM] = true;
                    dfs(nextN, nextM, rainBox, state);
            }
        }
    }

    private static int[][] createRainBox(int target) {
        int [][] rainBox = new int[N][N];
        for (int i=0; i < N; i ++) {
            for (int j=0; j < N; j++) {
                rainBox[i][j] = box[i][j] <= target ? 0 : box[i][j];
            }
        }
        return rainBox;
    }
}
