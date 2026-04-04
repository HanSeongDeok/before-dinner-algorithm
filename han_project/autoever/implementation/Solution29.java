package implementation;

import java.util.Arrays;

public class Solution29 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        for (String s : arr) {
            answer += s;
        }

        return answer.startsWith("0")? "0" : answer;
    }
}
