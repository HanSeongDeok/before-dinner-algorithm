package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution47 {
    private class Info {
        String word;
        int count;
        public Info(String word, int count){
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Deque<Info> dq = new ArrayDeque<>();
        dq.add(new Info(begin, 0));
        boolean[] state = new boolean[words.length];

        while (!dq.isEmpty()) {
            Info info = dq.poll();
            if (target.equals(info.word)) {
                answer = info.count;
                break;
            }
            
            for (int i=0; i<words.length; i++) {
                if (!state[i] && valid(words[i], info)) {
                    state[i] = true;
                    dq.add(new Info(words[i], info.count + 1));
                } 
            }
        }
        return answer;
    }

    private boolean valid(String w, Info info) {
        int count = 0;
        for (int i=0; i < w.length(); i++) {
            if (w.charAt(i) == info.word.charAt(i)) count++;
            if (count == w.length()-1) return true;
        }
        return false;
    }
}
