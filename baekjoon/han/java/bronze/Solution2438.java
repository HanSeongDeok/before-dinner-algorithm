package bronze;

import java.io.*;

/**
 * BAEKJOON
 * 2438. 별 찍기 - 1
 */
public class Solution2438 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<=i; j++) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
