#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    
    vector<vector<int>> vec;
    int sum = 0;
    
    for(int i = 1 ; i < n + 1 ; i ++){
        sum += i;
        vector<int> row(i);
        vec.push_back(row);
    }
    
    int num = 1;
    int direct = 0;
        
    int idx = 0;
    int jdx = 0;
    
    for(int i = n ; i > 0 ; i -- ){
        if(direct % 3 == 0){
            for(int j = 0 ; j < i ; j ++ ){
                vec[idx++][jdx] = num++;
            }
            jdx++;
            idx--;
        }
        else if(direct % 3 == 1){
            for(int j = 0 ; j < i ; j ++ ){
                vec[idx][jdx++] = num++;
            }
            idx --;
            jdx -= 2;
        }
        else{
            for(int j = 0 ; j < i ; j ++ ){
                vec[idx--][jdx--] = num++;
            }
            idx += 2;
            jdx += 1;
        }
        direct++;
    }
    
    for(auto a : vec){
        for(auto b : a){
            answer.push_back(b);
        }
    }

    return answer;
}