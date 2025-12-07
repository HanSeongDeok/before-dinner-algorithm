package dp.baekjoon;
import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 2156. 포도주 시식
 */
public class Solution2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[N];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(box[0]);
            return;
        }

        if (N == 2) {
            System.out.println(box[0] + box[1]);
            return;
        }
        
        int memo[] = new int[N];
        memo[0] = box[0];
        memo[1] = box[0] + box[1];
        memo[2] = Math.max(box[0] + box[2], box[1] + box[2]);
        memo[2] = Math.max(memo[1], memo[2]); 

        for (int i=3; i < N; i++) {
            memo[i] = Math.max(
                memo[i-2] + box[i], 
                memo[i-3] + box[i-1] + box[i]
            );
            memo[i] = Math.max(memo[i-1], memo[i]);
        }

        System.out.println(memo[N-1]);
    }
}

