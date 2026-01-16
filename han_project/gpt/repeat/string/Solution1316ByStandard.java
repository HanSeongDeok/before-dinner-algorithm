package repeat.string;

import java.io.*;

public class Solution1316ByStandard {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=0; i < N; i++) {
            String word = br.readLine();
            char prevW = 0;
            
            boolean isDupl = false;
            boolean[] state = new boolean[26];
            
            for (char w : word.toCharArray()) {
                if (prevW == w) continue;
                if (state[w - 'a']) {
                    isDupl = true;
                    break;
                }
                prevW = w;
                state[w - 'a'] = true;
            }
            if (isDupl) continue;
            answer++;
        }
        System.out.println(answer);
    }
}
