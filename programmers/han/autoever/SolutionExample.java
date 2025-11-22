package solution.autoever;

/**
* - 오토에버 테스트 문제
* 알고리즘 유형: 구현(Implementation), 해시/카운팅 또는 단순 조건 분기
*/
public class SolutionExample {
    public int[] solution(int[][] arr) {
        int x = 0, y = 0;
        
        if (arr[0][0] == arr[1][0]) x = arr[2][0];
        else if (arr[0][0] == arr[2][0]) x = arr[1][0];
        else if (arr[1][0] == arr[2][0]) x = arr[0][0];
        
        if (arr[0][1] == arr[1][1]) y = arr[2][1];
        else if (arr[0][1] == arr[2][1]) y = arr[1][1];
        else if (arr[1][1] == arr[2][1]) y = arr[0][1];

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SolutionExample sol = new SolutionExample();
        int[][] arr = {{1, 4}, {3, 4}, {3, 10}};
        int[] result = sol.solution(arr);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}