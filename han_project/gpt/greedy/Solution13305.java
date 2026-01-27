package greedy;

import  java.io.*;
import  java.util.*;
/**
 * BAEKJOON
 * 13305. 주유소
 */
public class Solution13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] distanceBox = new long[N-1];
        long[] box =  new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) distanceBox[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) box[i] = Integer.parseInt(st.nextToken());

        long target = box[0];
        for (int i=1; i< N; i++) {
            target = Math.min(target, box[i]); 
            box[i] = target; 
        }

        long answer = 0;
        for (int i =0; i < N-1; i++) {
            answer += distanceBox[i] * box[i];
        }
        System.out.println(answer);
    }
}
