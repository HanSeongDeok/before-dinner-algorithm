package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1789. 수들의 합
 */
public class Solution1789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        long S = Long.parseLong(st.nextToken());
        
        long count = 0, sum = 0;
        for (long i=1; i <= S; i++) {
            if (sum + i <= S) {
                count++;
                sum += i;
            } else break;
        }
        System.out.println(count);   
    }    
}
