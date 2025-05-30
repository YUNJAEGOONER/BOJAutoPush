import java.util.*;

class Solution {
    
    public int convert(String str){
        int code;
        if(str.equals("code")){
            code = 0;
        }
        else if(str.equals("date")){
            code = 1;
        }
        else if(str.equals("maximum")){
            code = 2;
        }
        else{
            code = 3;
        }
        return code;
    }
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int count = 0;
        
        int code = convert(ext);
        for(int i = 0 ; i < data.length ; i ++ ){
            if(data[i][code] > val_ext){
                data[i][0] = 0;
                count ++;
            }
        }
        
        answer = new int[data.length - count][data[0].length];
        
        int idx = 0;
        for(int i = 0 ; i < data.length ; i ++ ){
            if(data[i][0] != 0){
                for(int j = 0 ; j < data[0].length ; j ++ ){
                    answer[idx][j] = data[i][j];
                }
                idx ++;
            }
        }
        
        int sort_code = convert(sort_by);
        
        Arrays.sort(answer, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                return a[sort_code] - b[sort_code];
            }
        });
        
        return answer;
    }
}