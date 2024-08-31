import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int i = 0 ; i < commands.length ; i ++ ){
            int end = commands[i][1];
            int start = commands[i][0];
            int [] temp = new int[end - start + 1];
            for(int j = 0; j < end - start + 1 ; j ++ ){
                temp[j] = array[j + (start - 1)];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}