package bronze;

import java.io.*;
import  java.util.*;
/**
 * BAEKJOON
 * 4101. 크냐?
 */
public class Solution4101 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            if (F == 0 && S == 0) break; 
            sb.append((F > S) ? "Yes" : "No").append("\n");
        }
        System.out.println(sb.toString());
    }
}
