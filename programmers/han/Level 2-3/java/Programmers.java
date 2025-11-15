import solution.Solution62;

public class Programmers {
    public static void main(String[] args){
        // 62번 문제 (두 큐 합 같게 만들기)
        int answer = new Solution62().solution(
            new int[]{1, 2, 3, 5}, 
            new int[]{1, 1, 2, 2});
        System.out.println(answer);
    }
}
