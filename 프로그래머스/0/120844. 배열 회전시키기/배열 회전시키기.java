class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        answer = new int [numbers.length];
        switch (direction){
            case "right":
                for(int i = 0 ; i < numbers.length; i ++ ){
                    answer[(i + 1) % numbers.length] = numbers[i];
                }
                break;
            case "left":
                for(int i = 0 ; i < numbers.length; i ++ ){
                    answer[(i + numbers.length - 1) % numbers.length] = numbers[i];
                }
        }
        return answer;
    }
}