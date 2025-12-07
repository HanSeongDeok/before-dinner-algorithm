package dp.baekjoon;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 14002. 가장 긴 증가하는 부분 수열 4
 */
public class Solution14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[N];
        int[] memo = new int[N];
        Arrays.fill(memo, 1);        
        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i < N; i++) {
            for (int j=0; j < i; j++) {
                if (box[i] > box[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]); 
                }
            } 
        }

        List<Integer> trace = new ArrayList<>(); 
        int maxLen = Arrays.stream(memo).max().getAsInt();
        int maxIdx = -1;
        for (int j = 0; j < N; j++) {
            if (memo[j] == maxLen) maxIdx = j;
        }
        trace.add(box[maxIdx]);

        for (int i=maxLen; i > 0; i--) {            
            for (int j = 0; j < N; j++) {
                if (memo[j] == i && box[maxIdx] > box[j]) {
                    trace.add(box[j]);
                    maxIdx = j;
                    break;
                }
            }
        }

        System.out.println(maxLen);
        trace.sort(Comparator.naturalOrder());
        for (int t : trace) {
            System.out.print(t + " ");
        }
    }
}
