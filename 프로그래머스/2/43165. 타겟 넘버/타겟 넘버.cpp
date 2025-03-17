#include <string>
#include <vector>
#include <iostream>

using namespace std;


vector<int> temp;
vector<int> nums;
int answer = 0;

void dfs(int depth, int size, int t){
    if(depth == size){
        int sum = 0;
        for(int i = 0 ; i < size ; i ++ ){
            if(temp[i] == 0){
                sum -= nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        if(sum == t){
            answer ++;
        }
        return; 
    }
    for(int i = 0 ; i < 2 ; i ++ ){
        temp.push_back(i);
        dfs(depth + 1, size, t);
        temp.pop_back();
    }
}

int solution(vector<int> numbers, int target) {
   
    nums = numbers;
    
    dfs(0, numbers.size(), target);
    return answer;
}