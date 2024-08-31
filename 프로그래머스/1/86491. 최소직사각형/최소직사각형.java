class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max = -1;
        for(int i = 0 ; i < sizes.length; i ++ ){
            if(sizes[i][0] >= max)max = sizes[i][0];
            if(sizes[i][1] >= max)max = sizes[i][1];
        }
        
        int other = -1;
        for(int i = 0 ; i < sizes.length; i ++ ){
            int temp = (sizes[i][0] > sizes[i][1]) ? sizes[i][1] : sizes[i][0];
            if(other < temp) other = temp;
        }
        
        answer = max * other;
        return answer;
    }
}