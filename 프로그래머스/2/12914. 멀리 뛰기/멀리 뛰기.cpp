#include <string>
#include <vector>

using namespace std;

vector<int> memo;

long long fibo(int n){
    if(n == 1 || n == 0) return memo[n] = 1;
    
    if(memo[n] != 0) return memo[n];
    
    return memo[n] = (fibo(n-1) + fibo(n -2)) % 1234567;  
}

long long solution(int n) {
    for(int i = 0 ; i < n + 1 ; i ++ ){
        memo.push_back(0);
    }
    long long answer = fibo(n);
    return answer;
}