package repeat.string;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Solution1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = Pattern.compile("(.)\\1+").matcher(st.nextToken()).replaceAll("$1");
            boolean[] visited = new boolean[26];
            boolean isValid = true;
            for (char w : word.toCharArray()) {
                if (visited[w - 'a']) {
                    isValid = false;
                    break;
                }
                visited[w - 'a'] = true;
            }
            if (isValid) answer++;
        }
        System.out.println(answer);
    }
}
