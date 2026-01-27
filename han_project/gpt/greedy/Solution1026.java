package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1026. 보물  
 */
public class Solution1026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i ++) A[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i ++) B[i] = Integer.parseInt(st.nextToken());

        B = Arrays.stream(B).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        A = Arrays.stream(A).sorted().toArray();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += B[i] * A[i];
        }
        System.out.println(sum);
    }
}
