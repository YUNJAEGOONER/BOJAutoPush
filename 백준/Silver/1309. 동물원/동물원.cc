//
// Created by Yunjae on 2025-02-20.
//
#include<iostream>
#include<vector>
using namespace std;

int main(){

  int dp[100001][3];

  dp[0][0] = 1;
  dp[0][1] = 1;
  dp[0][2] = 1;



  int n;
  cin >> n;

  for(int i = 1 ; i < n + 1 ; i ++ ) {
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i -1][2]) % 9901;
    dp[i][1] = (dp[i - 1][0] + dp[i -1][2]) % 9901;
    dp[i][2] = (dp[i - 1][0] + dp[i -1][1]) % 9901;
  }

  int result = dp[n][0];
  cout << result;

  return 0;
}