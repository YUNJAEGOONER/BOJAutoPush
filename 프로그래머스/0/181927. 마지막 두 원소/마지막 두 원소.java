class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        int len = num_list.length;
        answer = new int [len + 1];
        for(int i = 0 ; i < len; i ++ ){
            answer[i] = num_list[i];
        }
        int last = (num_list[len - 1] > num_list[len - 2]) ?
            num_list[len - 1] - num_list[len - 2] : num_list[len - 1] * 2;
        answer[len] = last;
        return answer;
    }
}