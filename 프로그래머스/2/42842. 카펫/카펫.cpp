#include <iostream>
#include <string>
#include <vector>
#include <cmath>


using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int total = brown + yellow;
    //가로가 더 길어야함
    for(int i = 3; i <= sqrt(total); i ++ ){
        if(total % i == 0){
            int j = total / i;
            if((j - 2) * (i - 2) == yellow){
                answer.push_back(j);
                answer.push_back(i);
            }
        }
    }
    
    return answer;
}