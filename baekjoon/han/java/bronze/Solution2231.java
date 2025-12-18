package bronze;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2231. 분해합
 */
public class Solution2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        for (int i = N/2; i < N; i++) {
            String[] targets = String.valueOf(i).split("");
            int sum = Arrays.stream(targets).mapToInt(Integer::parseInt).sum();
            if (N == i + sum) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
