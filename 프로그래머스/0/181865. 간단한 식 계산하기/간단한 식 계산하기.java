class Solution {
    public int solution(String binomial) {
        int answer = 0;
        int space = binomial.indexOf(' ');
        
        int a = Integer.parseInt(binomial.substring(0, space));
        int b = Integer.parseInt(binomial.substring(space+3));
        
        char op = binomial.charAt(space +1);
        
        switch(op){
            case '+':
                answer = a + b;
                break;
            case '-':
                answer = a - b;
                break;
            case '*':
                answer = a * b;
                break;
        }
        return answer;
    }
}