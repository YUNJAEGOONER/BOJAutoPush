class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int [] visit = new int [n];
        for(int i = 0 ; i < section.length ; i ++ ){
            visit[section[i] - 1] = 1;
        }
        
        for(int i = 0 ; i < section.length ; i ++ ){
            int cur = section[i] - 1;
            if(visit[cur] == 1){
                int end = cur + m >= n ? n  : cur + m; 
                for(int j = cur ; j < end ; j++ ){
                    visit[j] = 0;
                }
                answer ++;
            }
        }
        return answer;
    }
}