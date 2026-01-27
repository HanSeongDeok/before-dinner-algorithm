package repeat.brute_force;

import java.util.*;
import java.io.*;

/**
 * 복습 - 암호만들기 정답
 */
public class Solution1759 {
    private static StringBuilder answer = new StringBuilder();
    private static int L, C;
    private static String box[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        box = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < C; i++) {
            String s = st.nextToken();
            box[i] = s;
        }

        Arrays.sort(box);
        // System.out.println("[DEBUG]: " + Arrays.toString(box));

        dfs(0, new StringBuilder());
        System.out.println(answer.toString());

    }

    private static void dfs(int idx, StringBuilder sb) {
        if (sb.length() == L) {
            if (isValid(sb)) {
                answer.append(sb.toString()).append("\n");
            }
            return;
        }

        for (int i=idx; i < C; i++) {
            sb.append(box[i]);
            dfs(i + 1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    //자음: t c s w
    //모음: a i
    private static boolean isValid(StringBuilder target) {
        int jaCount = 0, moCount = 0;
        for (char c : target.toString().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moCount++;
            } else {
                jaCount++;
            }
        }
        return jaCount >= 2 && moCount >= 1;
    }
}
