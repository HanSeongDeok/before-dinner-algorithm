package brute_force.baekjoon;

import java.io.*;
import java.util.*;

public class Solution1759 {
    static int L;
    static int C;
    static String[] chars;
    static List<String> answer = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < C; i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);
        dfs(0, new StringBuilder());
        answer.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
    private static void dfs (int idx, StringBuilder targets) {
        if (targets.length() == L) {
            int cnt1 = 0, cnt2 = 0;
            for (char c : targets.toString().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c=='u') {
                    cnt1++;
                } else {
                    cnt2++;
                }
            }
            if (cnt1 >= 1 && cnt2 >= 2) {
                answer.add(targets.toString());
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            targets.append(chars[i]);
            dfs(i + 1, targets);
            targets.deleteCharAt(targets.length() - 1);
        }
    }
}
