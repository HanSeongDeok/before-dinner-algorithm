package greedy;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 2839. 설탕 배달
 * greedy 문제 -> 3을 빼고 5로 나눠볼 생각을 했어야지
 * 5를 빼면서 3을 나누고 있었음...
 */
public class Solution2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        while (N > 0) {
            int nextN = N % 5;
            if (nextN == 0) {
                count += N / 5;
                break;
            }
            N -= 3;
            count++;
        }
        if (N < 0) count = -1;
        System.out.println(count);
    }
}
