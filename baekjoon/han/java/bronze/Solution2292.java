package bronze;

import java.io.*;
import  java.util.*;

/**
 * BAEKJOON
 * 2292. 벌집
 */
public class Solution2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long answer = 1;

        long cnt = 0;
        for (long i=2; i <= N; i += cnt) {
            cnt += 6;
            answer += 1;
            if (i < N && N < i + cnt) break;
        }

        System.out.println(answer);
    }
}
