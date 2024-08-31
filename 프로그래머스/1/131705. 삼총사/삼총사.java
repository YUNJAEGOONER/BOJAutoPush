class Solution {
    int [] students;
    int [] visit;
    int answer = 0;
    
    public void check_sum(){
        int sum = 0;
        for(int i = 0 ; i < visit.length; i ++ ){
            if(visit[i] == 1){
                sum = sum + students[i];
            }
        }
        if(sum == 0)answer++;
    }
    
    public void dfs_combi(int idx, int cnt){
        if(cnt == 3){
            check_sum();
            return;
        }
        for(int i = idx ; i < visit.length; i ++ ){
            if(visit[i] == 1)continue;
            visit[i] = 1;
            dfs_combi(i , cnt + 1);
            visit[i] = 0;
        }
    }
    
    
    public int solution(int[] number) {
        Solution sol = new Solution();
        sol.visit = new int[number.length];
        sol.students = number;
        sol.dfs_combi(0, 0);
        return sol.answer;
    }
}