package implementation;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2161. 카드 1
 */
public class Solution2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int box[] = new int[N * 2];
        int answer[] = new int[N];

        for (int i=1; i<=N; i++) box[i-1] = i; 
        
        int index = 0; 
        int answerIdx = 0;
        while(answerIdx < N-1) {
            answer[answerIdx++] = box[index];
            box[index++] = 0;
            
            box[N - 1 + answerIdx] = box[index];
            box[index++] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) sb.append(answer[i]).append(" ");
        sb.append(box[N * 2 -2]);
        System.out.println(sb.toString());
    }
}
