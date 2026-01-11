import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        int answer = -1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i <= 8 ; i ++ ){
            
            Set<Integer> row = new HashSet<>();
            sb.append(N);
            
            int num = Integer.parseInt(sb.toString());
            row.add(num);
        
            for(int j = 1 ; j <= i / 2 ; j ++){
                
                Set <Integer> a = dp.get(j);
                Set <Integer> b = dp.get(i - j);
                
                for(int na : a){
                    for(int nb : b){                
                        row.add(na + nb);
                        row.add(na - nb);
                        row.add(nb - na);
                        row.add(na * nb);
                        if(nb != 0){
                            row.add(na/nb);
                        }
                        if(na != 0){
                            row.add(nb/na);
                        }
                    }
                }
                
            }
            
            dp.add(row);
            
            for(int n : row){
                if(n == number){
                    answer = i;
                    return answer;
                }
            }
            System.out.println();
          
            
        }
        
        return answer;
    }
}