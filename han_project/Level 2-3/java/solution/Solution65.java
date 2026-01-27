package solution;

import java.util.*;
import java.util.stream.*;

/**
 * 65. 베스트앨범
 * 알고리즘 유형: 해시맵, 정렬
 */
public class Solution65 {
    /**
     * @Day1
     */
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String,Integer> genresTotalPlay = new HashMap<>();
        Map<String, List<int[]>> genresInIdByPlays = new HashMap<>();
       
        for (int i=0; i < genres.length; i++) {
            genresTotalPlay.put(genres[i], genresTotalPlay.getOrDefault(genres[i], 0) + plays[i]);
            genresInIdByPlays.computeIfAbsent(genres[i], x -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }

        List<String> sortedGenres = genresTotalPlay.keySet().stream()
            .sorted((a, b) -> genresTotalPlay.get(b) - genresTotalPlay.get(a))
            .collect(Collectors.toList());
    
        for (String key : sortedGenres) {
            int[] sortedPlays = genresInIdByPlays.get(key).stream()
                .sorted((a, b) -> b[1] - a[1])
                .mapToInt(arr -> arr[0]).toArray();
            
            for (int i = 0; i < Math.min(2, genresInIdByPlays.get(key).size()); i++){
                answer.add(sortedPlays[i]);
            }
        }

        return answer.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        Solution65 s65 = new Solution65();
        
        int[] result = s65.solution(
            new String[]{"classic", "pop", "classic", "classic", "pop"}, 
            new int[]{500, 600, 150, 800, 2500});

        System.out.println(Arrays.toString(result)); // [4, 1, 3, 0]
    }
}
