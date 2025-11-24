package implementation;

/**
 * 75. 문자열 압축
 */
public class Solution75 {
    // 프로그래머스 '문자열 압축' 문제 풀이
    public int solution(String s) {
        int minLen = s.length();

        for (int len = 1; len <= s.length() / 2; len++) {
            StringBuilder result = new StringBuilder();
            String prev = s.substring(0, len);
            int count = 1;

            for (int j = len; j <= s.length(); j += len) {
                String next;
                if (j + len <= s.length()) {
                    next = s.substring(j, j + len);
                } else {
                    next = s.substring(j);
                }

                if (prev.equals(next)) {
                    count++;
                } else {
                    if (count > 1) {
                        result.append(count).append(prev);
                    } else {
                        result.append(prev);
                    }
                    prev = next;
                    count = 1;
                }
            }
            minLen = Math.min(minLen, result.length());
        }

        return minLen;
    }

    /**
     * @Day 1 -> 내 풀이
     * @param s
     * @return
     */
    public int solution2(String s) {
        int answer = s.length();
        for (int i= 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            String next = "";
            int cnt = 1;
            int remainder = s.length() % i;
            for (int j = i; j <= s.length() - i; j+=i) {
                next = s.substring(j, j+i);
                if(prev.equals(next)) {
                    cnt += 1;
                } else {
                    if (cnt > 1) sb.append(String.valueOf(cnt) + prev);
                    else sb.append(prev);
                    cnt = 1;
                }
                prev = next;
            }
            if (cnt > 1) sb.append(String.valueOf(cnt) + prev);
            else sb.append(next);
            if (remainder > 0) sb.append(s.substring(s.length()-remainder)); 

            // System.out.println(sb.toString());
            answer = Math.min(answer, sb.length());
        }
        // System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution75 s75 = new Solution75();
        s75.solution2("aabbaccc");
        s75.solution2("ababcdcdababcdcd");
        s75.solution2("abcabcdede");
        s75.solution2("abcabcabcabcdededededede");
        s75.solution2("xababcdcdababcdcd");
    }
}
