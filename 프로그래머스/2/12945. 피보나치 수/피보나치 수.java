import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        
        List<Integer> fibo = new ArrayList<>();
        
        for(int i = 0 ; i <= n ; i ++ ){
            if(i == 0 || i == 1) fibo.add(i);
            else fibo.add((fibo.get(i - 1) + fibo.get(i - 2)) % 1234567);
        }
        
        return fibo.get(n);
    }
}