package greedy;

import java.io.*;
import java.util.*;

public class Solution11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int box[] = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = N-1; i >=0; i--) {
            if (K == 0) break;
            if (box[i] <= K) {
                count += K / box[i]; 
                K %= box[i];
            } 
        }
        System.out.println(count);
    }
}
