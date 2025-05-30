class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target = board[h][w];
        
        //상
        if(h - 1 >= 0 && board[h-1][w].equals(target)){
            answer ++;
        }
        //하
        if(h + 1 < board.length && board[h+1][w].equals(target)){
            answer ++;
        }
        //좌
        if(w - 1 >= 0 && board[h][w-1].equals(target)){
            answer ++;
        }
        //우
        if(w + 1 < board[0].length && board[h][w+1].equals(target)){
            answer ++;
        }
        
        return answer;
    }
}