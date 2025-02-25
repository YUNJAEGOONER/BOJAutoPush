#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int> > land)
{

    vector<vector<int>> dp(land.size());
    
    for(int i = 0 ; i < land[0].size() ; i ++ ){
        dp[0].push_back(land[0][i]);
    }
    
    
    for(int i = 1 ; i < land.size() ; i ++  ){
        for(int j = 0 ; j < land[i].size() ; j ++ ){
            int max = -1;
            for(int k = 0 ; k < dp[i - 1].size() ; k ++ ){
                if(max < dp[i - 1][k] && (j != k)){
                    max = dp[i - 1][k];
                }
            }
            dp[i].push_back(max + land[i][j]);
        }
    }

    int answer = -1;
    vector<int> result = dp[land.size() - 1];
    for(auto a : result){
        if(answer < a){
            answer = a;
        }
    }

    return answer;
}