package repeat.brute_force;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON 14888. 연산자 끼워넣기
 * (복습) 오답 
 */
public class Solution14888 {
    private static int[] calCount = new int[4];
    private static int[] box;
    private static int N;
    private static long maxAnswer = Integer.MIN_VALUE;
    private static long minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        box = new int[N];
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calCount[i] = Integer.parseInt(st.nextToken());
        }
        dfs(box[0], 1);
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    private static void dfs(long target, int idx) {
        int count = 0;
        for (int i = 0; i < 4; i++)
            count += calCount[i];
        if (count == 0) {
            maxAnswer = Math.max(target, maxAnswer);
            minAnswer = Math.min(target, minAnswer);
            return;
        }
        if (calCount[0] > 0) {
            calCount[0]--;
            dfs(target + box[idx], idx + 1);
            calCount[0]++;
        }

        if (calCount[1] > 0) {
            calCount[1]--;
            dfs(target - box[idx], idx + 1);
            calCount[1]++;
        }

        if (calCount[2] > 0) {
            calCount[2]--;
            dfs(target * box[idx], idx + 1);
            calCount[2]++;
        }

        if (calCount[3] > 0) {
            calCount[3]--;
            dfs(target / box[idx], idx + 1);
            calCount[3]++;
        }
    }
}
