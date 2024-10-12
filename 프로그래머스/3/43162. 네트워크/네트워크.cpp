#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    vector<int> visit;
    
    for(int i = 0 ; i < n ; i ++ ){
        computers[i][i] = 0;
        visit.push_back(1);
    }
    
    for(int k = 0 ; k < n ; k ++ ){
        if(visit[k]){
            answer ++;
            vector<int> ms;
            ms.push_back(k);
                
            while(ms.size()){      
                int cur_idx = ms.back();
                ms.pop_back();
                visit[cur_idx] = 0;
                for(int i = 0 ; i < n ; i ++ ){
                    if((computers[cur_idx][i] != 0) && (visit[i] == 1)) ms.push_back(i);
                }
            }
            
        }
    }
    
    return answer;
}