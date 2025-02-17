#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    
    int correct = 0;

    map<int, int> mmap;
    
    for(int i = 0 ; i < lottos.size() ; i ++ ){
        mmap[lottos[i]]++;
    }
    
    
    for(int i = 0 ; i < win_nums.size(); i ++ ){
        if(mmap[win_nums[i]]){
            correct++;
        }
    }
    
    //맞힌갯수, 순위
    map<int, int> rank;
    int n = 1;
    
    for(int i = 6; i > -1 ; i --){
        if(i >= 2){
            rank[i] = n;
            n ++;
        }
        else{
            rank[i] = 6;
        }
    }
    
    answer.push_back(rank[correct + mmap[0]]);
    answer.push_back(rank[correct]);

    return answer;
}