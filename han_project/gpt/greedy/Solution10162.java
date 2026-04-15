package greedy;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 10162. 전자레인지
 */
public class Solution10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = 0, B = 0, C = 0;
        A = N / 300;
        B = (N % 300) / 60;
        C = ((N % 300) % 60) / 10;
        if (N % 10 != 0) System.out.println(-1);
        else System.out.println(A + " " + B + " " + C);
    }
}
