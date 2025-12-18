package greedy;

import  java.io.*;
import  java.util.*;

/**
 * BAEKJOON
 * 11399. ATM
 * 
 * 국소 최적이 전체 최적인지 확인 하는 것 == 그리디
 */
public class Solution11399 {
    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] box = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(box);
            // System.out.println(Arrays.toString(box));

            int sum = 0, answer = 0;
            for (int b : box) {
                sum += b; 
                answer +=sum;  
            }
            System.out.println(answer);
    }
}
