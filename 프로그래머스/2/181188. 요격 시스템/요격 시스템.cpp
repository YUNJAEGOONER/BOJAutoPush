#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool cmp(vector<int> v1, vector<int> v2){
    return v1[1] < v2[1];
}

int solution(vector<vector<int>> targets) {
    
    sort(targets.begin(), targets.end(), cmp);
    
    int end = targets[0][1];
    int answer = 1;
    
    for(int i = 1 ; i < targets.size(); i ++ ){
        if(end <= targets[i][0]){
            answer ++;
            end = targets[i][1];
        }
        // s < targets[i][1]
    }
    
    return answer;
}