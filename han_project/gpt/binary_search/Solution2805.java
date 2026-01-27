package binary_search;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2805. 나무 자르기
 */
public class Solution2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int box[] = new int[N];

        st = new StringTokenizer(br.readLine());
        int maxValuue = 0;
        for (int i = 0; i < N; i++) {
            box[i] =  Integer.parseInt(st.nextToken());
            maxValuue = Math.max(box[i], maxValuue);
        }

        long low = 0;
        long high = maxValuue;
        long answer = 0;
        while(low <= high) {
            long mid = (high + low) / 2;
            long sum = 0;
            for (int b : box) {
                long value = b - mid > 0 ? b - mid : 0; 
                sum +=  value;
            }
            if (M <= sum) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }    
}
