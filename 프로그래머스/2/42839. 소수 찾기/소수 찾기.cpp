#include <string>
#include <vector>
#include <set>
#include <math.h>
#include <iostream>

using namespace std;
int answer = 0;
vector<int> visit;
vector<int> result;
set<int> primes;

int check_prime(int n){
    int result = 1;
    if (n < 2){
        result = 0;
    }
    else{
        for(int i = 2 ; i <= sqrt(n) ; i ++ ){
            if(n % i == 0) result = 0;
        }
    }
    return result;
}


void dfs_combi(string numbers, int start, int end, int count){
    if(result.size() > 0){
        int num = 0;
        for(int i = 0 ; i < result.size() ; i ++ ){
            num = (num * 10) + (numbers[result[i]] - '0');
        }
        if(check_prime(num))primes.insert(num);
    }
    for(int i = 0; i < end ; i ++ ){
        if(visit[i] == 1) continue;
        visit[i] = 1;
        result.push_back(i);
        dfs_combi(numbers, i, end, count + 1);
        result.pop_back();
        visit[i] = 0;
    }
}

int solution(string numbers) {
    
    for(int i = 0 ; i < numbers.length() ; i ++ ){
        visit.push_back(0);
    }
    
    dfs_combi(numbers, 0, visit.size(), 0);
    answer = primes.size();
    return answer;
}