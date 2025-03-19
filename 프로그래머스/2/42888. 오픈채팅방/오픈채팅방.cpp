#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<string> to_vec(string str){
    
    vector<string> result;
    string temp = "";
    for(int i = 0 ; i < str.size() ; i ++ ){
        if(str[i] == ' '){
            result.push_back(temp);
            temp = "";
        }
        else{
            temp += str[i];
        }
    }
    result.push_back(temp);
    return result;
}


vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    map<string, string> mmap;
    
    for(int i = 0 ; i < record.size() ; i ++ ){
        vector<string> cur = to_vec(record[i]);
        if(cur.size() == 3){
            mmap[cur[1]] = cur[2];
        }
    }
    
        
    for(int i = 0 ; i < record.size() ; i ++ ){
        vector<string> cur = to_vec(record[i]);
        if(cur[0] == "Enter"){
            string res = "";
            res += mmap[cur[1]];
            res += "님이 들어왔습니다.";
            answer.push_back(res);
        }
        else if(cur[0] == "Leave"){
            string res = "";
            res += mmap[cur[1]];
            res += "님이 나갔습니다.";
            answer.push_back(res);
        }
    }
    
    
    return answer;
}