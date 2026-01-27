package silver;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 11726. 2n 타일링
 */
public class Solution11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        if (N == 3) {
            System.out.println(3);
            return;
        }

        int [] box = new int[N];
        box[0] = 2;
        box[1] = 2;
        box[2] = 3;

        for (int i = 3; i < N; i++) {
            box[i] = box[i-2] + box[i-1] % 10007;
        }
        System.out.println(box[N-1] % 10007);
    }
}
