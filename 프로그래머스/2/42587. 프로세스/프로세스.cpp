#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;


int solution(vector<int> priorities, int location) {
    int answer = 0;
 
    vector<pair<int, int>> mmap;
    for(int i = 0 ; i < priorities.size() ; i ++ ){
        mmap.push_back(make_pair(i, priorities[i]));
    }
    
    sort(priorities.rbegin(), priorities.rend());

    while(mmap.size()){
        if(priorities[0] == mmap.begin()->second){
            answer ++;
            if(mmap.begin()->first == location){
                break;
            }
            priorities.erase(priorities.begin());
            mmap.erase(mmap.begin());
        }
        else{
            int id = mmap.begin()->first;
            int temp = mmap.begin()->second;
            mmap.push_back(make_pair(id, temp));
            mmap.erase(mmap.begin());
           
        }
    }
    
    return answer;
}