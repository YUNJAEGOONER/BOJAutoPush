#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    
    set<pair<int, int>> mset;
    
    while(true){
        for(int i = 0 ; i < m ; i ++ ){
            for(int j = 0 ; j < n ; j ++ ){
                int target = board[i][j];
                if(target != '0'){
                    if((j + 1 < n && board[i][j + 1] == target) &&
                       (i + 1 < m && board[i + 1][j] == target) &&
                       (board[i + 1][j + 1] == target))
                    {
                    mset.insert(make_pair(i, j));
                    mset.insert(make_pair(i, j + 1));
                    mset.insert(make_pair(i + 1, j));
                    mset.insert(make_pair(i + 1, j + 1));
                    }
                }
            }
        }
        for(auto a : mset){
            board[a.first][a.second] = '0';
        }
        
        for(int i = m - 1 ; i > -1 ; i -- ){
            for(int j = 0; j < n ; j ++ ){
                int temp_idx = i;
                if(board[i][j] == '0'){
                    while(temp_idx >= 0){
                        if(board[temp_idx][j] != '0'){
                            board[i][j] = board[temp_idx][j];
                            board[temp_idx][j] = '0';
                            break;
                        }
                        temp_idx --;
                    }
                }
            }
        }
        
        answer += mset.size();
        if(mset.size() == 0){
            break;
        }
        mset.clear();
    }
       
    return answer;
}