package solution.autoever.bfs;
import java.util.*;

/**
 * 46. 단어변환
 * 알고리즘 유형: 너비 우선 탐색(BFS)
 */
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


    /**
     * @ Day 2
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution2(String begin, String target, String[] words) {
        Deque<Words> dq = new ArrayDeque<>();
        boolean[] memo = new boolean[words.length];
        dq.offer(new Words(begin, 0));
        
        while (!dq.isEmpty()) {
            Words infos = dq.poll();
            String word = infos.word;
            int count = infos.count;

           if (word.equals(target)) {
            return count;
           } 

            for (int i=0; i < words.length; i++) {
                if (!memo[i] && isValidation(word, words[i])) {
                    memo[i] = true;
                    dq.offer(new Words(words[i], count+1));
                }
            } 
        }
        return 0;
    }

    private boolean isValidation(String word, String compareWord) {
        int sameCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == compareWord.charAt(i)) {
                sameCnt += 1;
            }
        }
        return sameCnt == word.length()-1;
    }

    private class Words {
        String word;
        int count;
        public Words(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Solution46 s46 = new Solution46();
        int answer = s46.solution2("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(answer);
    }
}
