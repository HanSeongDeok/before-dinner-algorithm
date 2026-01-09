package repeat.string;

import java.io.*;
import java.util.regex.Pattern;

public class Solution1316 {
    public static void main(String[] args) throws IOException{
        // System.out.println(solution1());
        System.out.println(solution2());
    }

    private static int solution1() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i=0; i < N; i++) {
            String word = br.readLine();
            boolean visited[]  = new boolean[26];
            char preW = 0;
            boolean isDupl = true;
            for (char w : word.toCharArray()) {
                if (preW == w) continue;
                if (visited[w-'a']) {
                    isDupl = false;
                    break;
                }
                visited[w-'a'] = true;
                preW = w;
            }
            if (isDupl) answer++;   
        }
        return answer;
    } 

    private static int solution2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=0; i < N; i++) {
            String word = br.readLine();
            word = Pattern.compile("(.)\\1+").matcher(word).replaceAll("$1");
            boolean visited[] = new boolean[26];
            boolean isDupl = true;
            for (char c : word.toCharArray()) {
                if (visited[c-'a']) {
                    isDupl = false;
                    break;
                }
                visited[c-'a'] = true;
            }
            if (isDupl) answer++;
        }

        return answer;
    }
}
