#include <string>
#include <vector>

using namespace std;

vector<long long> dp;

long long fibo(int n){
    if (n == 0 || n == 1){
        return dp[n] = 1;
    }
    else{
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1000000007;
    }
    
}

int solution(int n) {
    int answer = 0;
    dp = vector<long long>(n + 1);
    answer = fibo(n);
    return answer;
}