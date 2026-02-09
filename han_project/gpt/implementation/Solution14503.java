package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON 
 * 14503. 로봇 청소기
 */
public class Solution14503 {
    public static int[] mapN= {};
    public static int[] mapM= {};

    public static boolean[][] visit;
    public static int[][] box;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visit = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
         
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r, c, d});
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) box[i][j] = Integer.parseInt(st.nextToken());
        }

        while(!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1], direction = infos[2];
            
            if (!visit[curN][curM]) {
                answer++;
                visit[curN][curM] = true;
            }
        
            if (direction == 0) {
                mapN = new int[]{0, 1, 0, -1};
                mapM = new int[]{-1, 0, 1, 0};
            } else if (direction == 1) {
                mapN = new int[]{-1, 0, 1, 0};
                mapM = new int[]{0, -1, 0, 1};
            } else if (direction == 2) {
                mapN = new int[]{0, -1, 0, 1};
                mapM = new int[]{1, 0, -1, 0};
            } else if (direction == 3){
                mapN = new int[]{1, 0, -1, 0};
                mapM = new int[]{0, 1, 0, -1};   
            }
            moveNextDirection(curN, curM, direction, dq);
        }
        System.out.println(answer);
    }

    private static void moveNextDirection(int curN, int curM, int direction, Deque<int[]> dq) {
        for (int i=0; i<4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (box[nextN][nextM] == 0 && !visit[nextN][nextM]) {
                int nextD = checkNextDirectionInfo(direction, i);
                dq.add(new int[]{nextN, nextM, nextD});
                break;
            }
        }
        if (dq.isEmpty()) {
            if (direction == 0 && box[curN+1][curM] == 0) dq.add(new int[]{curN+1, curM, direction});
            if (direction == 1 && box[curN][curM-1] == 0) dq.add(new int[]{curN, curM-1, direction});
            if (direction == 2 && box[curN-1][curM] == 0) dq.add(new int[]{curN-1, curM, direction});
            if (direction == 3 && box[curN][curM+1] == 0) dq.add(new int[]{curN, curM+1, direction});
        }
    }

    private static int checkNextDirectionInfo(int direction, int i) {
        if (direction == 0) {
            if (i == 0) return 3;
            if (i == 1) return 2;
            if (i == 2) return 1;  
        } else if (direction == 1) {
            if (i == 0) return 0;
            if (i == 1) return 3;
            if (i == 2) return 2;  
        } else if (direction == 2) {
            if (i == 0) return 1;
            if (i == 1) return 0;
            if (i == 2) return 3;
        } else if (direction == 3){
            if (i == 0) return 2;
            if (i == 1) return 1;
            if (i == 2) return 0;
        }
        return direction;
    } 
}
