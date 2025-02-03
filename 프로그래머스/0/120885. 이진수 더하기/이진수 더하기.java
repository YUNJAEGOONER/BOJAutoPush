class Solution {
    public String solution(String bin1, String bin2){
            
        int sum = btod(bin1) + btod(bin2);
 
        return dtob(sum);
    }
    
    public int btod(String bin){
        int b = 1;
        int result = 0;
        for(int i = bin.length() - 1 ; i > -1 ; i -- ){
            result = result + (bin.charAt(i) -'0') * b;
            b = b * 2;
        }
        return result;
    }
    
    public String dtob(int dec){
        String answer = "";
        do{
            answer = answer + (dec % 2);
            dec = dec / 2;  
        }while(dec != 0);
        StringBuffer strbuf = new StringBuffer(answer);
        return strbuf.reverse().toString();
    }
}