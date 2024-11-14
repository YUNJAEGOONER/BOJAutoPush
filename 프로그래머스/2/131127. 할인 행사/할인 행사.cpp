#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    map<string, int> basket;
    for(int i = 0 ; i < want.size() ; i ++ ){
        basket[want[i]] = number[i];
    }
    
    for(int i = 0 ; i < discount.size() - 10 + 1 ; i ++ ){
        map<string, int> temp;
        temp = basket;
        int count = 0;
        for(int j = i ; j < i + 10 ; j ++ ){
            if(temp[discount[j]] == 0)break;
            else{
                --temp[discount[j]];
                if(temp[discount[j]] == 0) count++;
            }
        }
        if(count == want.size())answer++;
    }
    
    cout << answer;
    
    return answer;
}