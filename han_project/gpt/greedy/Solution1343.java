package greedy;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1343. 폴리오미노
 */
public class Solution1343 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> targets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char prevW = ' ';
        for (Character c : st.nextToken().toCharArray()) {
            if (c == '.') {
                if (prevW != '.') {
                    targets.add(sb.toString());
                    sb = new StringBuilder();
                }
                targets.add(".");
            }
            else sb.append(c);
            prevW = c;
        }
        targets.add(sb.toString());
        
        sb = new StringBuilder();
        for (String s : targets) {
            if (s.equals(".")) {
                sb.append(s);
                continue;
            }
            if (s.length() % 2 == 1) {
                sb = new StringBuilder();
                sb.append("-1");
                break;
            } else {
                int countA = s.length() / 4;
                int remain = s.length() % 4;

                for (int i=0; i < countA; i++) sb.append("AAAA");
                if (remain > 0) sb.append("BB");
            }
        }

        System.out.println(sb.toString());
    }
}
