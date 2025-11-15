package solution.autoever.bfs;
import java.util.*;
public class Solution46 {

    public int solution(String begin, String target, String[] words) {
        Deque<WordInfo> dq = new ArrayDeque<>();
        dq.offer(new WordInfo(begin, 0)) ;
        boolean[] memo = new boolean[words.length];

        while (!dq.isEmpty()) {
            WordInfo infos = dq.poll();
            String currentWord = infos.word; 
            int count = infos.count;

            if (currentWord.equals(target)) {
                return count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!memo[i] && isValid(currentWord, words[i])) {
                    memo[i] = true;
                    dq.offer(new WordInfo(words[i], count+1));
                }
            }

        }
        return 0;
    }

    public boolean isValid(String currentWord, String word) {
        int sameCnt = 0;
        for (int i =0; i < word.length(); i++) {
            if (currentWord.charAt(i) == word.charAt(i)) {
                sameCnt += 1;
            } 
        }
        return sameCnt == word.length()-1;
    }

    public class WordInfo {
        String word;
        int count;
        public WordInfo(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }  

    public static void main(String[] args) {
        Solution46 s46 = new Solution46();
        int answer = s46.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);
    }
}
