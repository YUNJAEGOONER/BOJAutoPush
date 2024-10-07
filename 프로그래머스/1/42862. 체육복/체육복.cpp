#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    
    vector <int> check (n);
    
    for(int i = 0 ; i < check.size() ; i ++ ){
        check[i] ++;
    }
    
    for(int i = 0 ; i < reserve.size() ; i ++ ){
        check[reserve[i] - 1] ++ ;
    }
    for(int i = 0 ; i < lost.size() ; i ++ ){
        check[lost[i] - 1] --;
    }
    
    for(int i = 0 ; i < check.size() ; i ++ ){
        if(check[i] == 0){
            if (i - 1 >= 0 and check[i - 1] == 2){
                check[i - 1] -- ;
                check[i] ++ ;
            }
            else if (i + 1 <= n and check[i + 1] == 2){
                check[i + 1] --;
                check[i] ++;
            }
        }
    }
    
    for(int i = 0 ; i < check.size() ; i ++ ){
        if(check[i] > 0) answer ++;
    }

    return answer;
}