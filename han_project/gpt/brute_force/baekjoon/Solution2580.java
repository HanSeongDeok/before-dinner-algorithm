package brute_force.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 2580. 스도쿠
 */
public class Solution2580 {
    static int[][] box = new int[9][9];
    static List<int[][]> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        for (int[] a : answer.get(0)) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    private static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row+1, 0);
            return;
        }

        if (row == 9) {
            int[][] copied = new int[9][9];
            for (int i = 0; i < 9; i++) {
                copied[i] = Arrays.copyOf(box[i], 9);
            }
            answer.add(copied);
            return;
        }

        if (box[row][col] > 0) {
            dfs(row, col + 1);
            return;
        }

        for (int n = 1; n <= 9; n++) {
            if (isValid(row, col, n)) {
                box[row][col] = n;
                dfs(row, col + 1);
                box[row][col] = 0;
            }
        }
    }

    private static boolean isValid(int row, int col, int num) {
        for (int n : box[row]) {
            if (n == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (box[i][col] == num) return false;
        }

        int rowValue = (row/3)*3;
        int colValue = (col/3)*3;
        for (int i = rowValue; i < rowValue + 3; i++) {
            for (int j = colValue; j < colValue+3; j++) {
                if (box[i][j] == num) return false;
            }
        }

        return true;
    }
}
