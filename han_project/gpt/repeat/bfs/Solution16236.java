package repeat.bfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 16236. 아기 상어 문제
 * 오답노트 작성하기
 * 
 * 핵심 
 * -> 먹이를 먹은 후 (한번 끊음)데이터 정제 및 초기화 
 * -> 다시 새로운 state와 시작 dq로 시작  
 */
public class Solution16236 {
    private static int N;
    private static int[][] box;
    private static int mapN[] = {1, -1, 0, 0};
    private static int mapM[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        box = new int[N][N];

        int[] start = new int[2];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 9) {
                    start[0] = i; 
                    start[1] = j;
                    box[i][j] = 0;
                }
            }
        }

        int answer = 0, eat = 0, size = 2;
        while (answer < Integer.MAX_VALUE) {
            int[] info = {start[0], start[1], size, eat, 0};
            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(info);

            boolean[][] state = new boolean[N][N];
            state[start[0]][start[1]] = true;
            
            List<int[]> infos = bfs(dq, state); 
            if (infos.isEmpty()) break;

            start[0] = infos.get(0)[0];
            start[1] = infos.get(0)[1];
            box[start[0]][start[1]] = 0;
            size = infos.get(0)[2];
            eat = infos.get(0)[3];

            if (eat == size) {
                size ++;
                eat = 0;
            }
            answer += infos.get(0)[4];
        }
        
        System.out.println(answer);
    }

    private static List<int[]> bfs(Deque<int[]> dq, boolean[][] initState) {
        boolean[][] state = initState;
        List<int[]> storage = new ArrayList<>();

        while (!dq.isEmpty()) {    
            int[] info = dq.poll();
            int curN = info[0], curM = info[1], size = info[2], eat = info[3], second = info[4];
            
            if (!storage.isEmpty() && second > storage.get(0)[4]) {
                break;
            } 

            if (box[curN][curM] > 0 && size > box[curN][curM]) {
                storage.add(new int[] {curN, curM, size, eat + 1, second});
            }

            for (int i = 0; i < 4; i ++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < N && 
                    !state[nextN][nextM] && size >= box[nextN][nextM]) {
                        state[nextN][nextM] = true;
                        dq.add(new int[] {nextN, nextM, size, eat, second + 1});
                } 
            }
        }
        storage.sort((a, b) -> a[1] - b[1]);
        storage.sort((a, b) -> a[0] - b[0]);
        return storage;
    }
}
