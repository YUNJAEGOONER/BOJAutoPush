import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 10 ; i ++ ){

            int n = Integer.parseInt(br.readLine());

            int answer = 0;

            List<Integer> buildings = new ArrayList<>();
            String [] heights = br.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++ ){
                buildings.add(Integer.parseInt(heights[j]));
            }

            for(int j = 2 ; j < buildings.size() - 2 ; j ++ ){
                int cur = buildings.get(j);
                int max = 0;
                for(int k = j - 2 ; k <= j + 2 ; k ++ ){
                    if(k != j && max < buildings.get(k)){
                        max = buildings.get(k);
                    }
                }
                if(max < cur){
                    answer += (cur - max);
                }
            }
            System.out.printf("#%d %d\n", (i + 1), answer);
        }
    }

}