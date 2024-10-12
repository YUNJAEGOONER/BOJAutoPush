#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<int> visit;
vector<int> element;
int answer = 0;


void dfs_target(int start, int end, int count, int target){
    int sum = 0;
    if(count > 0){
        for(int i = 0 ; i < visit.size() ; i ++ ){
            if(visit[i] == 1){
                sum = sum + (-1) * element[i];
            }
            else{
                sum = sum + element[i];
            }
        }
        if(sum == target) answer ++;
    }
    for(int i = start ; i < end; i ++ ){
        if(visit[i])continue;
        visit[i] = 1;
        dfs_target(i, end, count + 1, target);
        visit[i] = 0;
    }
}

int solution(vector<int> numbers, int target) {
    
    
    for(int i = 0 ; i < numbers.size(); i ++ ){
        visit.push_back(0);
    }
    
    element = numbers;
    dfs_target(0, numbers.size(), 0, target);
    
    return answer;
}