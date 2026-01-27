package repeat.string;

import java.io.*;
import java.util.*;

public class Solution2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        Deque<Character> dq = new ArrayDeque<>();

        boolean isVaild = true;
        char prevW = 0;
        int answer = 0, cnt = 1;
        for (char w : word.toCharArray()) {
            if (w == '(' || w == '[') {
                if (w == '(') cnt *= 2;
                if (w == '[') cnt *= 3;
                prevW = w;
                dq.add(w);
            } else {
                if (dq.isEmpty()) {
                    isVaild = false;
                    break;
                }
                char compareW = dq.pollLast();
                if ((w == ')' && compareW != '(' )|| (w == ']' && compareW != '[' )) {
                    isVaild = false;
                    break;
                }
                if (prevW == '(' || prevW == '[') {
                    answer += cnt;
                } 
                if (w == ')') cnt /= 2;
                if (w == ']') cnt /= 3;
                prevW = w;
            }
        }
        if (!dq.isEmpty()) isVaild = false;
        System.out.println(isVaild ? answer : 0); 
    }
}
