#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, int> &a, const pair<int, int> &b){
    return a.second > b.second;
} 

vector<int> solution(string s) {
    vector<int> answer;
      
    string temp = "";
    
    map<int, int> mmap;
        
    for(int i = 0 ; i < s.size() ; i ++ ){
        if(s[i] == ',' || s[i] == '}'){
            if(temp.size()){
                int num = stoi(temp);
                mmap[num] ++;
            }
            temp = "";
        }
        else if('0' <= s[i] && s[i] <= '9'){
            temp = temp + s[i];
        }
    }
    
    vector<pair<int, int>> mtov(mmap.begin(), mmap.end());
    sort(mtov.begin(), mtov.end(), cmp);
    
    for(auto e : mtov){
        answer.push_back(e.first);
    }
    
    return answer;
}