class Solution {
    public char convert(String num){
        char result = ' ';
        switch(num){
            case "zero":
                result = '0';
                break;
            case "one":
                result = '1';
                break;
            case "two":
                result = '2';
                break;
            case "three":
                result = '3';
                break;
            case "four":
                result = '4';
                break;
            case "five":
                result = '5';
                break;
            case "six":
                result = '6';
                break;
            case "seven":
                result = '7';
                break;
            case "eight":
                result = '8';
                break;
            case "nine":
                result = '9';
                break;
        }
        return result;
    }
    
    public int solution(String s) {
        int answer = 0;
        String str = "";
        for(int i = 0 ; i < s.length() ; i ++ ){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                str = str + s.charAt(i);
            }
            else{
                String temp ="";
                while('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                    temp = temp + s.charAt(i++);
                    if(temp.length() >= 3 && convert(temp) != ' '){
                        break;
                    }
                }
                i = i - 1;
                str = str + convert(temp);
            }
        }
        return Integer.parseInt(str);
    }
}