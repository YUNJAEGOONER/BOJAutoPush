#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    vector<vector<int>> dp;
    dp = triangle;
    
    for(int i = 0 ; i < triangle.size() - 1 ; i ++ ){
        for(int j = 0; j < triangle[i].size() ; j ++ ){
            if(dp[i + 1][j] < dp[i][j] + triangle[i + 1][j]){
                dp[i + 1][j] = dp[i][j] + triangle[i + 1][j];
                if(answer < dp[i + 1][j]){
                    answer = dp[i + 1][j];
                }
            }
            if(dp[i + 1][j + 1] < dp[i][j] + triangle[i + 1][j + 1]){
                dp[i + 1][j + 1] = dp[i][j] + triangle[i + 1][j + 1];
                if(answer < dp[i + 1][j + 1]){
                    answer = dp[i + 1][j + 1];
                }
            }
        }
    }
    
    return answer;
}