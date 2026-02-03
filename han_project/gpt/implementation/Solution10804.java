package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 10804. 카드 역배치
 */
public class Solution10804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] box = new int[21];
        for (int i=1; i <= 20; i++) box[i] = i;

        for (int i=0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            while(start < end) {
                int tmp = box[start];
                box[start] = box[end];
                box[end] = tmp;
                start++; 
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=20; i++) sb.append(box[i]).append(" ");
        System.out.println(sb.toString());
    }
}
