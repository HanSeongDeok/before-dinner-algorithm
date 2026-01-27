package silver;

import java.io.*;
import java.util.*;

public class Solution2630 {
    private static int blueCnt = 0;
    private static int whiteCnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[][] = new int[N][N]; 

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Deque<int[][]> dq = new ArrayDeque<>();
        dq.add(box);

        while(!dq.isEmpty()) {
            int[][] b = dq.poll();
            if (!isAllEqual(b)) {
                int n = b.length / 2;

                int[][] leftUpBox = new int[n][n];
                for (int i = 0; i < n; i++) {
                    leftUpBox[i] = Arrays.copyOfRange(b[i], 0, n);
                }
                dq.add(leftUpBox);

                int[][] rightUpBox = new int[n][n];
                for (int i = 0; i < n; i++) {
                    rightUpBox[i] = Arrays.copyOfRange(b[i], n, b.length);
                }
                dq.add(rightUpBox);

                int[][] leftDownBox = new int[n][n];
                for (int i = 0; i < n; i++) {
                    leftDownBox[i] = Arrays.copyOfRange(b[i + n], 0, n);
                }
                dq.add(leftDownBox);

                int[][] rightDownBox = new int[n][n];
                for (int i = 0; i < n; i++) {
                    rightDownBox[i] = Arrays.copyOfRange(b[i + n], n, b.length);
                }
                dq.add(rightDownBox);               
            } else {
                if (b[0][0] == 0) whiteCnt++;  
                else blueCnt++;  
            }
        }

        System.out.println(whiteCnt);
        System.out.println(blueCnt);        
    }

    private static boolean isAllEqual(int[][] box) {
        int compareValue = box[0][0];
        for (int[] b : box) {
            for (int v : b) {
                if (compareValue != v) return false;
            }
        }
        return true;
    } 
}
