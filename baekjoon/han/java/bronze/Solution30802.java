package bronze;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 30802. 웰컴 키트
 */
public class Solution30802 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<6; i++) {
            box[i] = Integer.parseInt(st.nextToken());    
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());

        int tCount = 0;
        for (int b : box) {
            int value =  b / T;
            tCount += (b % T) == 0 ? value : (value + 1);   
        }
        System.out.println(tCount);
        System.out.println((int) N / P + " " + (int) N % P);
    }
}
