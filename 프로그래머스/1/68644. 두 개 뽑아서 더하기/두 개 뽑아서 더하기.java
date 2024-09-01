import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < numbers.length ; i ++ ){
            for(int j = i + 1 ; j < numbers.length ; j ++ ){
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        
        // answer = set.stream().mapToInt(x->x).toArray();
        // Arrays.sort(answer);
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}