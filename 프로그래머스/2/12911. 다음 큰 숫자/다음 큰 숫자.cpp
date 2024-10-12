#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    int count = 0;
    
    int N = n;
    while(N != 0){
        if(N % 2) count ++;
        N = N / 2;
    }
    
    
    for(int i = n + 1; i < 1000000 ; i ++ ){
        int temp = i;
        int temp_cnt = 0;
        
        while(temp != 0){
            if(temp % 2) temp_cnt ++;
            temp = temp / 2;
        }
        
        if(temp_cnt == count){
            answer = i;
            break;
        }
    }
    
    return answer;
}