import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        for(int i = 0 ; i < flag.length; i ++){
            if(flag[i] == true){
                for(int j = 0 ; j < arr[i] * 2 ; j ++ ){
                    arrlist.add(arr[i]);
                }
            }
            else{
                for(int j = 0 ; j < arr[i] ; j ++ ){
                    arrlist.remove(arrlist.size() - 1);
                }
            }
        }
        return arrlist.stream().mapToInt(i->i).toArray();
    }
}