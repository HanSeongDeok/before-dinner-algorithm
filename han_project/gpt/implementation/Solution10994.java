package implementation;

import java.io.*;

public class Solution10994 {
    private static char [][] box; 
    private static int size = 1; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        for (int i=1; i<N; i++) size += 4;

        box = new char [size][size];
        dfs(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (char[] b : box) {
            for (char c : b) sb.append((c == 0) ? " " : c);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int N, int curN, int curM) {
        if (N == 1) {
            box[curN][curM] = '*';
            return;
        }

        int maxIndex = size-curN;
        for (int i =curN; i < maxIndex; i++) {
            box[curM][i] = '*';
            box[maxIndex-1][i] = '*';
            box[i][curM] = '*';
            box[i][maxIndex-1] = '*';
        }
        
        dfs(N-1, curN+2, curM+2);        
    }
}
