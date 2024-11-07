#include<iostream>
#include<vector>
using namespace std;

vector<int> memo;

int fibo_dp(int n){
    if(n == 1 || n == 0) return memo[n] = 1;
    if(memo[n] != 0) return memo[n];
    return memo[n] = (fibo_dp(n - 1) + fibo_dp(n - 2)) % 10007;
}

int main(){
    int n;
    cin >> n;
    
    for(int i = 0 ; i < n ; i ++ ) memo.push_back(0);
    int result = fibo_dp(n);
    cout << result ;
    return 0;
}