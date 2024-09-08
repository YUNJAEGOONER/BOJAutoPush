class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int [] visit = new int [n];
        for(int i = 0 ; i < section.length ; i ++ ){
            visit[section[i] - 1] = 1;
        }
        
        System.out.print("original : ");
        for(int i = 0 ; i < visit.length; i ++ ){
            System.out.print(visit[i]);
        }
        System.out.println();
        
        for(int i = 0 ; i < section.length ; i ++ ){
            int cur = section[i] - 1;
            if(visit[cur] == 1){
                int end = cur + m >= n - 1 ? n : cur+m; 
                for(int j = cur ; j < end ; j++ ){
                    visit[j] = 0;
                }
                answer ++;
            }
        }
        return answer;
    }
}