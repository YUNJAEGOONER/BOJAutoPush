#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    
    map<string, int> mmap;
    for(int i = 1 ; i < 27 ; i ++ ){
        string key = "";
        key += ('A' + (i - 1));
        mmap[key] = i;
    }
    
    int cnt = 1;
    
    for(int i = 0 ; i < msg.size() ; i ++ ){
        string temp = "";
        temp += msg[i];
        
        int idx = i;
        
        while(true){
            if(mmap[temp] == 0){
                mmap[temp] = 26 + cnt;
                cnt ++;
                i = idx - 1;
                break;
            }
            else{
                temp += msg[++idx];
            }
        }
        //cout << mmap[temp.substr(0, temp.size() - 1)] << ' ';
        answer.push_back(mmap[temp.substr(0, temp.size() - 1)]);
    }
    
    // for(auto a : mmap){
    //     cout << a.first << " : " << a.second << '\n';
    // }
    
    return answer;
}