class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] can = {"aya", "ye", "woo", "ma"};
        for(int i = 0 ; i < babbling.length ; i ++ ){
            for(int j = 0 ; j < can.length ; j ++ ){
                String convert = "" + (char)(j + '0');
                babbling[i] = babbling[i].replaceAll(can[j], convert);
            }
            System.out.println(babbling[i]);
        }
        
        for(int i = 0 ; i < babbling.length; i ++ ){
            int prev = -1;
            boolean check = true;
            for(int j = 0 ; j < babbling[i].length() ; j ++ ){
                int cur = (int)(babbling[i].charAt(j) -'0');
                if(cur >= 9){
                    check = false;
                    break;
                }
                else if(cur == prev){
                    check = false;
                    break;
                }
                prev = cur;
            }
            if(check) answer ++;
        }
        return answer;
    }
}