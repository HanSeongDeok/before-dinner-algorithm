package basic;
import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 11050. 이항계수 1 
 * (nCr)
 */
public class Solution11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] box = new int[N+1];
        for (int i=1; i <= N; i++) {
            box[i] = i;
        }
        int answer = 1;
        for (int i=0; i < K; i++) {
            answer *= box[N - i];
            answer /= (i + 1);
        }
        System.out.println(answer);
    }
}
