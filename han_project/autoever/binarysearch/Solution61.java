package binarysearch;

import java.util.*;

public class Solution61 {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int open=0, close=0, idx=0;
        for (char c : p.toCharArray()) {
            if (c == '(') open++;
            else close++;
            idx++;
            if (open == close) break;
        }        

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (isCollect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");

            String w = u.substring(1, u.length()-1);
            for (char c : w.toCharArray()) {
                sb.append(c == '(' ? ")" : "(");
            }
            return sb.toString();
        }
    }

    private boolean isCollect(String u) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : u.toCharArray()) {
            if (dq.isEmpty() && c == ')') return false;
            if (c == '(') dq.add(c);
            else dq.pollLast();
        }
        return dq.isEmpty();
    }
}
