#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    
    vector<int> mvec;
    
    vector<vector<int>> rboard;
    for(int j = 0 ; j < board.size() ; j ++ ){
        vector<int> row;
        for(int i = board.size() - 1 ; i > -1  ; i -- ){
            //cout << board[i][j] << ' ';
            if(board[i][j]) row.push_back(board[i][j]);
        }
        rboard.push_back(row);
    }
    board = rboard;
    
    for(int i = 0 ; i < moves.size() ; i ++){
        if(board[moves[i] -1].size()){
            int doll = board[moves[i] -1].back();
            board[moves[i] -1].pop_back();
            mvec.push_back(doll);
        }
        
        if(mvec.size() >= 2){
            if(*(mvec.end() - 1) == *(mvec.end() - 2)){
                mvec.pop_back();
                mvec.pop_back();
                answer += 2;
            }
        }
    }
    return answer;
}