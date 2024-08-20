class Solution {
    public int solution(int[] numbers) {
 
        int answer = 0;
        int max = numbers[0];
        int temp = 1;
        
        for(int i = 0 ; i < numbers.length ; i ++ ){
            if(max < numbers[i]){
                temp = max;
                max = numbers[i];
            }
            else{
                if(temp < numbers[i] && max != numbers[i]){
                    temp = numbers[i];
                }
            }
            System.out.print(i + " : " + max + " ");
            System.out.print(temp);
            System.out.println();
        }
        answer = temp * max;
        return answer;
    }
}