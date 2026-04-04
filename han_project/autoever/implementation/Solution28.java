package implementation;

import java.util.*;

public class Solution28 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // Arrays.sort(phone_book, (p1, p2) -> p1.length() - p2.length());
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(phone_book));

        for (int i=0; i<phone_book.length; i++) {
            for (int j=i+1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return answer;
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book); 
            for (int i=0; i < phone_book.length-1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution28 s = new Solution28();
        boolean answer = s.solution(new String[] {"12","123","1235","567","88"});
        System.out.println(answer);
    }
}
